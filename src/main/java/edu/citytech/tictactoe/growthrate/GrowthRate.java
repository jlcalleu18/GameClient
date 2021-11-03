package edu.citytech.tictactoe.growthrate;

import java.text.DecimalFormat;

public class GrowthRate {
    public static double getGrowRate(double years, double endingValue,
                                     double startValue, double totalDividends) {

        double x = ((endingValue + totalDividends) / startValue);
        double y = (1 / years);
        double x1 = Math.pow(x , y);
        double cagr = (x1 - 1) * 100;
        double roundOff = (double) Math.round(cagr * 100) / 100;
        return roundOff / 100;
    }

    public static void main(String[] args) {
       var result =  getGrowRate(1,150.20,100,0);
        DecimalFormat df = new DecimalFormat("#%");
        System.out.println(df.format(result));
    }

}
