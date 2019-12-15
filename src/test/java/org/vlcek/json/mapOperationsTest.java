package org.vlcek.json;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.*;

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
    public void testEmptyMapReturnsEmptyArrayAfterSortingMethod() {
        testMap.clear();
        testArray = mO.sortByValue(testMap).values().toArray();
        System.out.println(testArray);
        assertTrue(testArray.length == 0);
    }

    @Test
    public void testEmptyMapReturnsEmptyArrayAfterResortingMethod() {
        testMap.clear();
        mO.makeAndResortArrays(testMap);
        assertTrue(mO.completeArray.isEmpty());
    }

    @Test
    public void isSortingAlright_HighestIsFirst() {
        assertTrue((Integer)testArray[0] == 5);
    }

    @Test
    public void doubledValuesAreInOneElement() {
        mO.makeAndResortArrays(testMap);
        assertEquals("B  3\nC  3\n", mO.completeArray.get(1));
    }

    @Test
    public void areOutputHighestValuesOk() {
        mO.makeAndResortArrays(testMap);
        assertEquals('D', mO.threeHighestRates().charAt(0));
    }

    @Test
    public void areOutputLowestValuesOk() {
        mO.makeAndResortArrays(testMap);
        assertEquals('A',mO.threeLowestRates().charAt(0));
    }

}
