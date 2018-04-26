package org.difin.neo.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.difin.neo.model.api.Neo;
import org.difin.neo.model.api.NeoPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NeoRetrievalServiceTest {

    private NeoRetrievalService serviceUnderTest;
    private NeoAPIClient neoAPIClient = mock(NeoAPIClient.class);
    private DateRetrievalService dateRetrievalService = mock(DateRetrievalService.class);
    private static List<Neo> neoList;
    private static NeoPage neoPage0;
    private static NeoPage neoPage1;
    private static NeoPage neoPage2;

    @BeforeClass
    public static void initialSetup() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        neoPage0 = objectMapper.readValue(TestData.NEO_PAGE_0, NeoPage.class);
        neoPage1 = objectMapper.readValue(TestData.NEO_PAGE_1, NeoPage.class);
        neoPage2 = objectMapper.readValue(TestData.NEO_PAGE_2, NeoPage.class);

        neoList = neoPage0.getNear_earth_objects();
    }

    @Before
    public void setup() {
        serviceUnderTest = new NeoRetrievalService(neoAPIClient, dateRetrievalService);
    }

    @Test
    public void whenRetrievingNeoPagesViaAPIThenAllNeosFromAllRetrievedPagesArePresentInTheOutput(){

        when(neoAPIClient.getNumberOfBrowsePages()).thenReturn(2);
        when(neoAPIClient.getBrowsePage(0)).thenReturn(neoPage0);
        when(neoAPIClient.getBrowsePage(1)).thenReturn(neoPage1);
        when(neoAPIClient.getBrowsePage(2)).thenReturn(neoPage2);

        List<Neo> result = serviceUnderTest.getNeos();

        assertThat(result,
                hasSize(neoPage0.getNear_earth_objects().size() +
                        neoPage1.getNear_earth_objects().size() +
                        neoPage2.getNear_earth_objects().size()));

        assertThat(result.containsAll(neoPage0.getNear_earth_objects()), is(true));
        assertThat(result.containsAll(neoPage1.getNear_earth_objects()), is(true));
        assertThat(result.containsAll(neoPage2.getNear_earth_objects()), is(true));
    }

    @Test
    public void findLargestNeo(){

        Optional<Neo> largestNeo = serviceUnderTest.findLargestNeo(neoList);

        assertThat(largestNeo.isPresent(), is(true));
        assertThat(largestNeo.get().getName(), is("(1979 XB)"));
        assertThat(largestNeo.get()
                .getEstimated_diameter()
                .getKilometers()
                .getEstimated_diameter_max(), is(1.1325046106));
    }

    @Test
    public void whenLookingForClosestToEarthNeoForDateThatHasMultipleClosestNeosThanClosestOneIsFoundSuccesfully(){

        when(dateRetrievalService.getTodaysDate()).thenReturn("1991-10-07");

        Optional<Neo> closestToEarth = serviceUnderTest.findClosestToEarthNeo(neoList);

        assertThat(closestToEarth.isPresent(), is(true));
        assertThat(closestToEarth.get().getName(), is("(1992 YD3)"));
    }

    @Test
    public void whenLookingForClosestToEarthNeoForDateThatHasNoMatchesThenNoNeoIsFound(){

        when(dateRetrievalService.getTodaysDate()).thenReturn("some day when there are no close NEOs");

        Optional<Neo> closestToEarth = serviceUnderTest.findClosestToEarthNeo(neoList);

        assertThat(closestToEarth.isPresent(), is(false));
    }
}
