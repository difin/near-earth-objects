package org.difin.neo.services;

import org.difin.neo.model.api.Neo;
import org.difin.neo.model.internal.NeoRetrievalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

@Service
public class NeoRetrievalService {

    private final static int THREADS = 50;

    private NeoAPIClient neoAPIClient;
    private static final Logger logger = Logger.getLogger(NeoRetrievalService.class.getName());

    @Autowired
    public NeoRetrievalService(NeoAPIClient neoAPIClient){

        this.neoAPIClient = neoAPIClient;
    }

    public NeoRetrievalResult retrieveNeos() {

        List<Neo> neoList = getNeos();

        Optional<Neo> largestNeo = findLargestNeo(neoList);
        Optional<Neo> closestNeo = findClosestToEarthNeo(neoList);

        NeoRetrievalResult neoRetrievalResult = new NeoRetrievalResult();
        neoRetrievalResult.setClosestNeo(closestNeo);
        neoRetrievalResult.setLargestNeo(largestNeo);
        neoRetrievalResult.setNeoList(neoList);

        return neoRetrievalResult;
    }

    public List<Neo> getNeos() {

        logger.log(Level.INFO, "Starting retrieval of all NEOs, please wait...");

        int numberOfPages = neoAPIClient.getNumberOfBrowsePages();

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREADS);

        List<Neo> neoList = null;
        try {

            neoList = forkJoinPool.submit(() ->
                IntStream
                    .rangeClosed(0, numberOfPages)
                    .parallel()
                    .mapToObj(i -> neoAPIClient.getBrowsePage(i))
                    .flatMap(p -> p.getNear_earth_objects().stream())
                    .collect(Collectors.toList())).get();

        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Failed getting NEO data");
            e.printStackTrace();
            throw new RuntimeException("Error in getNeos method");
        } catch (ExecutionException e) {
            logger.log(Level.SEVERE, "Failed getting NEO data");
            e.printStackTrace();
            throw new RuntimeException("Error in getNeos method");
        }

        logger.log(Level.INFO, "Retrieval of all NEOs completed\n");

        return neoList;
    }

    public Optional<Neo> findLargestNeo(List<Neo> neos){

        logger.log(Level.INFO, "\nStarting to look for the largest NEO");

        Optional<Neo> largestNeo =
            neos
                .stream()
                .parallel()
                .filter(n -> n.getEstimated_diameter() != null)
                .filter(n -> n.getEstimated_diameter().getKilometers() != null)
                .filter(n -> n.getEstimated_diameter().getKilometers().getEstimated_diameter_max() != null)
                .collect(maxBy(Comparator.comparing(n -> n.getEstimated_diameter().getKilometers().getEstimated_diameter_max())));

        logger.log(Level.INFO, "Lookup for the largest NEO completed\n");

        return largestNeo;
    }

    public Optional<Neo> findClosestToEarthNeo(List<Neo> neos) {

        logger.log(Level.INFO, "Starting to look for the closest to Earth NEO");

        String todayDate = getTodaysDate();

        Optional<Neo> closestNeo =
            neos
                .stream()
                .parallel()
                .map(n -> {
                    n.getClose_approach_data().removeIf(d -> !d.getClose_approach_date().equals(todayDate));
                    return n;
                })
                .filter(n -> !n.getClose_approach_data().isEmpty())
                .filter(n -> n.getClose_approach_data().get(0).getOrbiting_body().equals("Earth"))
                .collect(minBy(Comparator.comparing(n ->
                        n.getClose_approach_data().get(0).getMiss_distance().getAstronomical())));

        logger.log(Level.INFO, "Lookup for the closest to Earth NEO completed\n");

        return closestNeo;
    }

    private String getTodaysDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
