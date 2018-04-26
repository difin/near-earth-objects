package org.difin.neo.services;

import org.difin.neo.model.api.NeoPage;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

@Component
public class NeoAPIClient {

    private static final String NEO_BROWSE_URL = "https://api.nasa.gov/neo/rest/v1/neo/browse";
    private static List<String> apiKeys;
    private static int counter = 0;

    private RestTemplate restTemplate;

    static {
        apiKeys = new ArrayList<>(
                Arrays.asList(
                        "GaUllVLUx3WVJ0N0BBrzy8NBnVFNSt75XcflMWt6",
                        "eZtFii9SUWYfhKfz2TLtvwbBDpHVw4T3oEomcRBA",
                        "s5xPq8yVBgVYghnxtRWzXxgIKhOPyrF0URX4I5Ea",
                        "3MX8aImn0Go2qXxrlMK3GvUpZQYuSd1RdVEzDrvf",
                        "luS7fvF5WXLnsDEhQqW7NrOgg48ZvhISAPf7cZN5",
                        "HlgpL20gLFA8s5FiCQjD9Vv4bmxvm9gaQ2Av1M7C",
                        "MDOiN7IKR0sVk8oHAOqoXR9cAHudIgMWTEPkP9ma",
                        "mpyIo4YueQ9Dh38SaRdpkCT7xkeRt5Rq3hoNmlO4",
                        "nkyGvNDnBXs7XoGU1R85FdNxq0LR6vXntVkOdzNm",
                        "aGsFY0R8RY4aYIpUVQ5bm8XyfyiXSB7yDcLz52xO",
                        "tPE51FOQnv8QDh16bsj1ajQhBnjB3rax9FzPLTSC",
                        "h54YYD0VxnQrJtDslf4zq85JLNqa5Mra2gMNGEGz",
                        "Uabm4LPWCjSdV9GRq3xGjTUGcBk0yY3W2xylGcEg",
                        "JgkCbay9IRgv1NWORCkiArt0BR3jyz1qr4bHuKA6",
                        "pczRN95VyXgAmG4IQ1QzoNM89Ar3SUgFdaXVvRbn",
                        "LzjELfdkbgdbsvQJrz7XQDHBXQVQayXCR5j0FMMg",
                        "ESxIQ9DM6K8mcNhEsA099VYwIBRZ96nlbHMhnv6H",
                        "p58xxYDM5BKkcoZ46LW0RT7urs9WeoAU4gfSO5Cc",
                        "svZ9b9IgYVeOpxEoWV4CbemDsuxIQAyvv2lnQD72",
                        "ZMcfB20GqiemQ5PmnXFWtSHqKUgMDTc3wqDDoUYO"
                ));
    }

    public NeoAPIClient(){
        restTemplate = new RestTemplate();;
    }

    public NeoPage getBrowsePage(int page) {

        String apiKey = getRandomApiKey();
        String url = NEO_BROWSE_URL + "?api_key=" + apiKey + "&page=" + page;

        try{
            return restTemplate.getForObject(url, NeoPage.class);

        } catch(HttpClientErrorException e){

            synchronized (apiKeys){
                apiKeys.remove(apiKey);
                System.out.println("API Key removed");
            }

            return getBrowsePage(page);
        } catch (ResourceAccessException e){

            try {
                sleep(1000);
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1.getCause());
            }

            return getBrowsePage(page);
        }
    }

    public int getNumberOfBrowsePages() {

        return getBrowsePage(0).getPage().getTotal_pages();
    }

    private String getRandomApiKey(){

        synchronized (apiKeys){

            counter++;
            int index = ThreadLocalRandom.current().nextInt(0, apiKeys.size());

            System.out.println("API Key number = " + index + ";\tAPI calls count = " + counter + ";\tRemaining API Keys = " + apiKeys.size());

            return apiKeys.get(index);
        }
    }
}