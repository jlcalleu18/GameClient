package edu.citytech.retirement;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.retirement.model.Retirement;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.Collections;

public class MainRetirement {
    public static void main(String[] args) {
        String sURL = "http://localhost:9814/retirement";
        var object = JSONGet.submitGet(sURL, Retirement.class);
        System.out.println(object);
    }
}
