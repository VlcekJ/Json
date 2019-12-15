package org.vlcek.json;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class mapOperationsTest {


    private mapOperations mO;

    HashMap<String, Integer> testMap = new HashMap<>();
    Object[] testArray;

    @Before
    public void createObjectAndFillTestMap() {
        mO = new mapOperations();
        testMap.put("C", 3);
        testMap.put("A", 1);
        testMap.put("B", 3);
        testMap.put("D", 5);
        testArray = mO.sortByValue(testMap).values().toArray();
    }

    @Test
    public void isSortingAlright() {
        assertTrue((Integer)testArray[0] == 5);
    }

    @Test
    public void doubledValuesInArrayTest() {
        mO.makeAndSortArrays(testMap);
        assertEquals("B  3\nC  3\n", mO.completeArray.get(1));
    }

    @Test
    public void areOutputHighestValuesOk() {
        mO.makeAndSortArrays(testMap);
        assertEquals('D', mO.threeHighestRates().charAt(0));
    }

    @Test
    public void areOutputLowestValuesOk() {
        mO.makeAndSortArrays(testMap);
        assertEquals('A',mO.threeLowestRates().charAt(0));
    }

}
