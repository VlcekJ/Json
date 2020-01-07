package org.vlcek.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.vlcek.json.objects.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

class JsonOperations {

    private Root root;
    private HashMap<String, Integer> mapOfStates = new HashMap<>();

     void getData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            root = objectMapper.readValue(new URL("http://jsonvat.com/"), Root.class);
        } catch (Exception E) {
            System.out.println("Can't read from URL.");
        }
    }

     void getData(String file) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(file));
            ObjectMapper objectMapper = new ObjectMapper();
            root = objectMapper.readValue(jsonData, Root.class);
        } catch (Exception E) {
            System.out.println("Can't read from file");
        }
    }

     void saveDataIntoMap() {
        getData();
        int countOfStates = root.getRates().size();
        for(int i = 0; i < countOfStates; i++) {
            mapOfStates.put(root.getRates().get(i).getName(), root.getRates().get(i).getPeriods().get(0).getRates().getStandard());
        }
    }

    HashMap<String, Integer> getMapOfStates() {
        return  mapOfStates;
    }

    Root getRoot() {
        return root;
    }
}
