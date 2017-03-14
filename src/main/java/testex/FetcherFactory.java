/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kim
 */
public class FetcherFactory implements IFetcherFactory {
    private final Map<String, IJokeFetcher> availableTypes = new HashMap<>();
    
    public FetcherFactory(){
        availableTypes.put("EduJoke", new EducationJoke());
        availableTypes.put("ChuckNorris", new ChuckNorris());
        availableTypes.put("Moma", new Moma());
        availableTypes.put("Tambal", new TambalJoke());
    }
    
    @Override
    public String[] getAvailableTypes() {
        String[] tempString = null;
        availableTypes.keySet().toArray(tempString);
        return tempString;
    }

    @Override
    public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
        String[] tempJokes = jokesToFetch.split(",");
        List<IJokeFetcher> tempJokeFetchers = new ArrayList<>();

        for (String joke : tempJokes) {
            if (availableTypes.containsKey(joke))
                tempJokeFetchers.add(availableTypes.get(joke));
        }
        
        return tempJokeFetchers;
    }

}
