package org.difin.neo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.difin.neo.model.internal.NeoRetrievalResult;
import org.springframework.stereotype.Service;

@Service
public class NeoPrintService {

    public void printRetrievalResults(NeoRetrievalResult result) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter =  objectMapper.writerWithDefaultPrettyPrinter();

        System.out.println("-----------------------------------------------------");
        System.out.println("Total number of NEOs: " + result.getNeoList().size());
        System.out.println("-----------------------------------------------------");

        System.out.println("Largest NEO:");

        if (result.getLargestNeo().isPresent()){
            System.out.println(objectWriter.writeValueAsString(result.getLargestNeo().get()));
        }
        else{
            System.out.println("No NEOs were found");
        }

        System.out.println("-----------------------------------------------------");

        System.out.println("Closest NEO:");

        if (result.getClosestNeo().isPresent()){
            System.out.println(objectWriter.writeValueAsString(result.getClosestNeo().get()));
        }
        else{
            System.out.println("Today no NEOs are close to Earth");
        }

        System.out.println("-----------------------------------------------------");
    }
}
