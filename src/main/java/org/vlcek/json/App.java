package org.vlcek.json;

public class App
{
    public static void main( String[] args ) {

        jsonOperations jO = new jsonOperations();
        mapOperations mO = new mapOperations();

        jO.saveDataIntoMap("data.json");
        mO.makeAndResortArrays(jO.getMapOfStates());

        System.out.println("Three highest rates in Europe:");
        System.out.println(mO.threeHighestRates());

        System.out.println("Three lowest rates in Europe:");
        System.out.println(mO.threeLowestRates());


    }
}
