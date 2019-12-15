package org.vlcek.json;

import org.junit.Before;
import org.junit.Test;


import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class jsonOperationsTest {

    jsonOperations jO;

    @Before
    public void setUp() {
        jO = new jsonOperations();
    }

    @Test
    public void areDownloadedDataInRightFormat() {
        jO.getData("data.json");
        assertTrue((jO.getRoot().getRates().get(0).getPeriods().get(0).getRates().getStandard() % 1) == 0);
    }

    @Test
    public void isGettingJasonDataOk() {
        jO.getData("example.json");
        int actualData = jO.getRoot().getRates().get(0).getPeriods().get(0).getRates().getStandard();
        assertEquals(21,actualData);
    }

    @Test
    public void isSavingDataIntoMapOk() {
        jO.saveDataIntoMap("example.json");
        assertTrue(jO.getMapOfStates().keySet().contains("Czech Republic"));
    }

}
