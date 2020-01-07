package org.vlcek.json;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MapOperationTest {
    private MapOperations mO;

    HashMap<String, Integer> testMap = new HashMap<>();
    Object[] testArray;

    @Before
    public void createObjectAndFillTestMap() {
        mO = new MapOperations();
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
        assertTrue(mO.getCompleteArray().isEmpty());
    }

    @Test
    public void isSortingAlright_HighestIsFirst() {
        mO.makeAndResortArrays(testMap);
        assertTrue((Integer)testArray[0] == 5);
    }

    @Test
    public void isSortingAlright_LowestIsLast() {
        mO.makeAndResortArrays(testMap);
        assertTrue((Integer)testArray[3] == 1);
    }

    @Test
    public void doubledValuesAreInOneElement() {
        mO.makeAndResortArrays(testMap);
        assertEquals("B  3\nC  3\n", mO.getCompleteArray().get(1));
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
