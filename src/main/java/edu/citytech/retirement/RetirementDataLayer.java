package edu.citytech.retirement;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.retirement.model.Retirement;

import java.util.stream.Stream;


public class RetirementDataLayer {

    public static Retirement getRetirement(int years) {
        String sURL = "http://localhost:9814/retirement?years="+years;
        var retirementData = JSONGet.submitGet(sURL, Retirement.class);
        return retirementData;
    }

    public static void main(String[] args) {
        var years = RetirementDataLayer.getRetirement(20).getYears();
        Stream.of(years).forEach(System.out::println);
    }
}
