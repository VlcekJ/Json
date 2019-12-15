package org.vlcek.json;

import java.util.*;

public class mapOperations {

    ArrayList<String> completeArray = new ArrayList<>();

    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public void makeAndSortArrays(HashMap<String, Integer> mapOfStates) {
        HashMap<String, Integer> sortedMap = sortByValue(mapOfStates);

        Object[] valuesArray = sortedMap.values().toArray();
        Object[] keysArray = sortedMap.keySet().toArray();
        Integer previousRate = 0;
        String s = "";
        int indexOfRate = 0;

        int indexOfLastObject = valuesArray.length - 1;

        for(int i = 0; i <= valuesArray.length; i++) {
            if (previousRate == 0) {
                s = (keysArray[i].toString() + "  " + valuesArray[i].toString());
                previousRate = (Integer) valuesArray[i];
            } else if (previousRate == valuesArray[indexOfLastObject]) {
                completeArray.add(indexOfRate, s + "\n");
            } else if (previousRate != valuesArray[i]) {
                completeArray.add(indexOfRate, s + "\n");
                s = "";
                s = (keysArray[i].toString() + "  " + valuesArray[i].toString());
                previousRate = (Integer) valuesArray[i];
                indexOfRate++;
            } else if (previousRate == valuesArray[i]) {

                s = s + ("\n" + keysArray[i].toString() + "  " + valuesArray[i].toString());
            }
        }
    }

    public String threeHighestRates() {
        String s = "";
        for(int i = 0; i <= 2; i++) {
            s = s + completeArray.get(i);
        }
        return s;
    }

    public String threeLowestRates() {
        String s = "";
        int lastThreeIndex = completeArray.size() - 3;
        for(int i = completeArray.size()-1; i >= lastThreeIndex; i--) {
            s = s + completeArray.get(i);
        }
        return s;
    }
}
