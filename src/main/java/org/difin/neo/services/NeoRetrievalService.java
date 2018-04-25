package org.difin.neo.services;

import org.difin.neo.model.api.Neo;
import org.difin.neo.model.api.NeoPage;
import org.difin.neo.model.internal.NeoRetrievalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

@Service
public class NeoRetrievalService {

    private final static int THREADS = 50;

    private NeoAPIClient neoAPIClient;

    @Autowired
    public NeoRetrievalService(NeoAPIClient neoAPIClient){

        this.neoAPIClient = neoAPIClient;
    }

    public NeoRetrievalResult retrieveNeos() throws ExecutionException, InterruptedException {

        List<Neo> neoList = getNeos();

        Optional<Neo> largestNeo = findLargestNeo(neoList);
        Optional<Neo> closestNeo = findClosestToEarthNeo(neoList);

        NeoRetrievalResult neoRetrievalResult = new NeoRetrievalResult();
        neoRetrievalResult.setClosestNeo(closestNeo);
        neoRetrievalResult.setLargestNeo(largestNeo);
        neoRetrievalResult.setNeoList(neoList);

        return neoRetrievalResult;
    }

    private List<Neo> getNeos() throws ExecutionException, InterruptedException {

        System.out.println("Starting retrieval of all NEOs");

        StopWatch watch = new StopWatch();
        watch.start();

        int numberOfPages = neoAPIClient.getNumberOfBrowsePages();

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREADS);

        List<Neo> neoList =
                forkJoinPool.submit(() ->
                    IntStream
                        .rangeClosed(0, numberOfPages)
                        .parallel()
                        .mapToObj(i -> neoAPIClient.getBrowsePage(i))
                        .flatMap(p -> p.getNear_earth_objects().stream())
                        .collect(Collectors.toList())).get();

        watch.stop();

        System.out.println("Retrieval of all NEOs completed in " + watch.getTotalTimeSeconds() + " seconds");

        return neoList;
    }

    private Optional<Neo> findLargestNeo(List<Neo> neos){

        System.out.println("\nStarting to look for the largest NEO");

        StopWatch watch = new StopWatch();
        watch.start();

        Optional<Neo> largestNeo =
            neos
                .stream()
                .parallel()
                .filter(n -> n.getEstimated_diameter() != null)
                .filter(n -> n.getEstimated_diameter().getKilometers() != null)
                .filter(n -> n.getEstimated_diameter().getKilometers().getEstimated_diameter_max() != null)
                .collect(maxBy(Comparator.comparing(n -> n.getEstimated_diameter().getKilometers().getEstimated_diameter_max())));

        watch.stop();

        System.out.println("Lookup for the largest NEO completed in " + watch.getTotalTimeSeconds() + " seconds\n");

        return largestNeo;
    }

    private Optional<Neo> findClosestToEarthNeo(List<Neo> neos) {

        System.out.println("Starting to look for the closest to Earth NEO");

        StopWatch watch = new StopWatch();
        watch.start();

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

        watch.stop();

        System.out.println("Lookup for the closest to Earth NEO completed in " + watch.getTotalTimeSeconds() + " seconds\n");

        return closestNeo;
    }

    private String getTodaysDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
