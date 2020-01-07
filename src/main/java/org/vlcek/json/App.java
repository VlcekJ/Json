package org.vlcek.json;

public class App
{
    public static void main( String[] args ) {

        JsonOperations jO = new JsonOperations();
        MapOperations mO = new MapOperations();

        jO.saveDataIntoMap();
        mO.makeAndResortArrays(jO.getMapOfStates());

        System.out.println("Three highest rates in Europe:");
        System.out.println(mO.threeHighestRates());

        System.out.println("Three lowest rates in Europe:");
        System.out.println(mO.threeLowestRates());

    }
}
