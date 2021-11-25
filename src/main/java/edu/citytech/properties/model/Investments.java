package edu.citytech.properties.model;

public class Investments {
        private float id;
        private float investmentCost;
        private float grossIncome;
        private float expense;
        private float netIncome;
        private float occupancy;

        public float getId() {
                return id;
        }

        public void setId(float id) {
                this.id = id;
        }

        public float getInvestmentCost() {
                return investmentCost;
        }

        public void setInvestmentCost(float investmentCost) {
                this.investmentCost = investmentCost;
        }

        public float getGrossIncome() {
                return grossIncome;
        }

        public void setGrossIncome(float grossIncome) {
                this.grossIncome = grossIncome;
        }

        public float getExpense() {
                return expense;
        }

        public void setExpense(float expense) {
                this.expense = expense;
        }

        public float getNetIncome() {
                return netIncome;
        }

        public void setNetIncome(float netIncome) {
                this.netIncome = netIncome;
        }

        public float getOccupancy() {
                return occupancy;
        }

        public void setOccupancy(float occupancy) {
                this.occupancy = occupancy;
        }

        @Override
        public String toString() {
                return "Investments{" +
                        "id=" + id +
                        ", investmentCost=" + investmentCost +
                        ", grossIncome=" + grossIncome +
                        ", expense=" + expense +
                        ", netIncome=" + netIncome +
                        ", occupancy=" + occupancy +
                        '}';
        }
}
