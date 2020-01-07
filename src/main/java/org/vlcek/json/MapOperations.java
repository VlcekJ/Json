package org.vlcek.json;

import java.util.*;

 class MapOperations {

    private ArrayList<String> completeArray = new ArrayList<>();

    HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
        if(map.isEmpty()) {
            return map;
        }
        else {
            HashMap<String, Integer> temp = new LinkedHashMap<>();
            List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            for (Map.Entry<String, Integer> aa : list) {
                temp.put(aa.getKey(), aa.getValue());
            }

            return temp;
        }
    }

    void makeAndResortArrays(HashMap<String, Integer> mapOfStates) {
        if (mapOfStates.isEmpty()) {
            System.out.println();
        } else {
            mapOfStates = sortByValue(mapOfStates);
            ArrayList<Integer> valueList = new ArrayList<>(mapOfStates.values());
            ArrayList<String> keyList = new ArrayList<>(mapOfStates.keySet());

            int previousRate = 0;
            int indexOfRate = 0;
            String s = "";
            int indexOfLastObject = valueList.size() - 1;

            for (int i = 0; i <= valueList.size(); i++) {
                if (previousRate == 0) {
                    s = (keyList.get(i) + "  " + valueList.get(i).toString());
                    previousRate = valueList.get(i);
                } else if (previousRate == valueList.get(indexOfLastObject)) {
                    completeArray.add(indexOfRate, s + "\n");
                } else if (previousRate != valueList.get(i)) {
                    completeArray.add(indexOfRate, s + "\n");
                    s = (keyList.get(i) + "  " + valueList.get(i).toString());
                    previousRate = valueList.get(i);
                    indexOfRate++;
                } else if (previousRate == valueList.get(i)) {
                    s += ("\n" + keyList.get(i) + "  " + valueList.get(i).toString());
                }
            }
        }
    }

    String threeHighestRates() {
        String s = "";
        for(int i = 0; i <= 2; i++) {
            s += completeArray.get(i);
        }
        return s;
    }

    String threeLowestRates() {
        String s = "";
        int lastThreeIndex = completeArray.size() - 3;
        for(int i = completeArray.size()-1; i >= lastThreeIndex; i--) {
            s += completeArray.get(i);
        }
        return s;
    }

    ArrayList<String> getCompleteArray() {
        return completeArray;
    }
}
