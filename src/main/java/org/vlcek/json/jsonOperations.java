package org.vlcek.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.vlcek.json.objects.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class jsonOperations {

    private Root root;

    private HashMap<String, Integer> mapOfStates = new HashMap<>();

    public void downloadData() {
        URL website = null;

        try {
            website = new URL("http://jsonvat.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (InputStream in = website.openStream()) {
            Files.copy(in, Paths.get("data.json"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(String source) {
        if(source.contains("data.json")) {
            downloadData();
        }
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(source));

            ObjectMapper objectMapper = new ObjectMapper();

            root = objectMapper.readValue(jsonData, Root.class);
        } catch (Exception E) {
            System.out.println("Can't read JSON file.");
        }
    }

    public void saveDataIntoMap(String source) {
        getData(source);
        int countOfStates = root.getRates().size();
        for(int i = 0; i < countOfStates; i++) {
            mapOfStates.put(root.getRates().get(i).getName(), root.getRates().get(i).getPeriods().get(0).getRates().getStandard());
        }
    }

    public HashMap<String, Integer> getMapOfStates() {
        return  mapOfStates;
    }

    public Root getRoot() {
        return root;
    }
}
