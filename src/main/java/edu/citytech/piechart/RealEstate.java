package edu.citytech.piechart;

public class RealEstate {
    private String state;
    private int stateCount;
    private float sumOfNetIncome;

    public RealEstate(String state, int stateCount, float sumOfNetIncome) {
        this.state = state;
        this.stateCount = stateCount;
        this.sumOfNetIncome = sumOfNetIncome;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStateCount() {
        return stateCount;
    }

    public void setStateCount(int stateCount) {
        this.stateCount = stateCount;
    }

    public float getSumOfNetIncome() {
        return sumOfNetIncome;
    }

    public void setSumOfNetIncome(float sumOfNetIncome) {
        this.sumOfNetIncome = sumOfNetIncome;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "state='" + state + '\'' +
                ", stateCount=" + stateCount +
                ", sumOfNetIncome=" + sumOfNetIncome +
                '}';
    }
}