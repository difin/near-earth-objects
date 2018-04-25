package org.difin.neo.services;

import org.difin.neo.model.api.NeoPage;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class NeoAPIClient {

    private static final String NEO_BROWSE_URL = "https://api.nasa.gov/neo/rest/v1/neo/browse";
    private static final List<String> apiKeys;

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
                        "aGsFY0R8RY4aYIpUVQ5bm8XyfyiXSB7yDcLz52xO"
                        ));
    }

    public NeoAPIClient(){
        restTemplate = new RestTemplate();;
    }

    public NeoPage getBrowsePage(int page) {

        String url = NEO_BROWSE_URL + "?api_key=" + getRandomApiKey() + "&page=" + page;

        return restTemplate.getForObject(url, NeoPage.class);
    }

    public int getNumberOfBrowsePages() {

        return getBrowsePage(0).getPage().getTotal_pages();
    }

    private String getRandomApiKey(){

        int index = ThreadLocalRandom.current().nextInt(0, apiKeys.size());
        return apiKeys.get(index);
    }
}