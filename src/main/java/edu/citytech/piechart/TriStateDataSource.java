package edu.citytech.piechart;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.properties.PropertiesDataLayer;
import edu.citytech.properties.model.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TriStateDataSource {
    public static List<RealEstate> getData(){

        List<RealEstate> list = new ArrayList<>();


        list.add(new RealEstate("NY", 25,50_0000));
        list.add(new RealEstate("CT", 26,30_0000));
        list.add(new RealEstate("NJ", 27,40_0000));

        return list;

    }

    public static void main(String[] args) {
        System.out.println(getData());
    }
}
