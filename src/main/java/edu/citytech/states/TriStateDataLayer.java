package edu.citytech.states;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.states.model.Property;
import edu.citytech.states.model.TriState;

import java.util.stream.Stream;


public class TriStateDataLayer {

    public static TriState[] getData(String... states) {
        var queryString = String.join(",", states);
        String sURL = "http://localhost:9615/allStates?states="+queryString;

        if(states.length == 0){
            sURL = "http://localhost:9615/allStates";
        }
        System.out.println(sURL);
        var statesData = JSONGet.submitGet(sURL, TriState[].class);
        return statesData;
    }


    public static Property[] getPropertiesData() {
        String sURL = "http://localhost:9615/properties/";
        var propertiesData = JSONGet.submitGet(sURL, Property[].class);
        return propertiesData;
    }


    public static void main(String[] args) {
        var states = TriStateDataLayer.getData();
        Stream.of(states).forEach(System.out::println);
        getPropertiesData();
//        var properties = TriStateDataLayer.getPropertiesData();
//        Stream.of(properties).forEach(System.out::println);

//
//        get the childrems
//                iterate to the if the is selected

    }
}
