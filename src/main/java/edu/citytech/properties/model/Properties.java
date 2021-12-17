package edu.citytech.properties.model;

import java.util.Arrays;

public class Properties {
    private float count;
    private Investments[] investments;
    private float netIncome;

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public Investments[] getInvestments() {
        return investments;
    }

    public void setInvestments(Investments[] investments) {
        this.investments = investments;
    }

    public float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(float netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return "Property{" +
                "count=" + count +
                ", investments=" + Arrays.toString(investments) +
                ", netIncome=" + netIncome +
                '}';
    }
}
