package org.difin.neo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.difin.neo.configuration.SpringConfiguration;
import org.difin.neo.model.internal.NeoRetrievalResult;
import org.difin.neo.services.NeoPrintService;
import org.difin.neo.services.NeoRetrievalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

public class Starter {

    public static void main(String[] args) throws ExecutionException, InterruptedException, JsonProcessingException {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        NeoRetrievalService neoRetrievalService = context.getBean(NeoRetrievalService.class);
        NeoPrintService neoPrintService = context.getBean(NeoPrintService.class);

        NeoRetrievalResult result = neoRetrievalService.retrieveNeos();
        neoPrintService.printRetrievalResults(result);
    }
}
