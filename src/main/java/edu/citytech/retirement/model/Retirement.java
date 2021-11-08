package edu.citytech.retirement.model;

import java.util.Arrays;

public class Retirement {
    private float daily20Days = 0;
    private float daily30Days = 0;
    private float monthlyDeposit = 0;
    private float startingBalance = 0;
    private float yearlyDeposit = 0;
    private Year[] years;
    private float yield = 0;


    public float getDaily20Days() {
        return daily20Days;
    }

    public void setDaily20Days(float daily20Days) {
        this.daily20Days = daily20Days;
    }

    public float getDaily30Days() {
        return daily30Days;
    }

    public void setDaily30Days(float daily30Days) {
        this.daily30Days = daily30Days;
    }

    public float getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public void setMonthlyDeposit(float monthlyDeposit) {
        this.monthlyDeposit = monthlyDeposit;
    }

    public float getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(float startingBalance) {
        this.startingBalance = startingBalance;
    }

    public float getYearlyDeposit() {
        return yearlyDeposit;
    }

    public void setYearlyDeposit(float yearlyDeposit) {
        this.yearlyDeposit = yearlyDeposit;
    }

    public Year[] getYears() {
        return years;
    }

    public void setYears(Year[] years) {
        this.years = years;
    }

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }

    @Override
    public String toString() {
        return "Retirement{" +
                "daily20Days=" + daily20Days +
                ", daily30Days=" + daily30Days +
                ", monthlyDeposit=" + monthlyDeposit +
                ", startingBalance=" + startingBalance +
                ", yearlyDeposit=" + yearlyDeposit +
                ", years=" + Arrays.toString(years) +
                ", yield=" + yield +
                '}';
    }
}
