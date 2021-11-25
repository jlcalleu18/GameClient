package edu.citytech.properties;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.properties.model.Properties;

import java.util.stream.Stream;


public class PropertiesDataLayer {

    public static Properties getProperties() {
        String sURL = "http://localhost:9814/properties";
        var propertiesData = JSONGet.submitGet(sURL, Properties.class);
        return propertiesData;
    }

    public static void main(String[] args) {
        var investments = PropertiesDataLayer.getProperties().getInvestments();
        Stream.of(investments).forEach(System.out::println);
    }
}