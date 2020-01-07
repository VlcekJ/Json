package org.vlcek.json;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonOperationsTest {
    private JsonOperations jO;

    @Before
    public void setUp() {
        jO = new JsonOperations();
    }

    @Test
    public void areDataInRightFormat() {
        Integer i = 0;
        jO.getData();
        assertEquals(i.getClass(), (jO.getRoot().getRates().get(0).getPeriods().get(0).getRates().getStandard().getClass()));
    }

    @Test
    public void isGettingJasonDataReal() {
        jO.getData("example.json");
        int actualData = jO.getRoot().getRates().get(0).getPeriods().get(0).getRates().getStandard();
        assertEquals(21, actualData);
    }

    @Test
    public void isSavingDataIntoMapOk() {
        jO.getData("example.json");
        jO.saveDataIntoMap();
        assertTrue(jO.getMapOfStates().containsKey("Czech Republic"));
    }
}
