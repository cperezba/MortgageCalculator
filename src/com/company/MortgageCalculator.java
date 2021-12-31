package com.company;

public class MortgageCalculator {
    private int principal;
    private float annualRate;
    private byte periodInYrs;

    public MortgageCalculator(int principal, float annualRate, byte periodInYrs) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.periodInYrs = periodInYrs;
    }

    public double calculateMortgage() {
        final double monthlyInterest = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        final double numberOfPayments = periodInYrs * Main.MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(double numberOfPaymentsMade) {
        final double monthlyInterest = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        final double numberOfPayments = periodInYrs * Main.MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;

    }

    public short getPeriodInYrs() {
        return periodInYrs;
    }
}
