package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double principal = (double) Console.userPrompt("Principal ($1k - $1M): ", 1_000, 1_000_000);
        double annualRate = (double) Console.userPrompt("Annual Interest Rate (1 - 30): ", 1, 30);
        double periodInYrs = (double) Console.userPrompt("Period(Years) (1 - 30): ", 1, 30);


        printMortgage(principal, annualRate, periodInYrs);
        printPaymentSchedule(principal, annualRate, periodInYrs);
    }


    private static void printMortgage(double principal, double annualRate, double periodInYrs) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(calculateMortgage(principal, annualRate, periodInYrs));
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }


    private static void printPaymentSchedule(double principal, double annualRate, double periodInYrs) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= periodInYrs * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualRate, periodInYrs, month);

            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        };
    }


    public static double calculateMortgage(double principal, double annualRate, double periodInYrs) {
        final double monthlyInterest = annualRate / PERCENT / MONTHS_IN_YEAR;
        final double numberOfPayments = periodInYrs * MONTHS_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double calculateBalance(double principal, double annualRate, double periodInYrs, double numberOfPaymentsMade) {
        final double monthlyInterest = annualRate / PERCENT / MONTHS_IN_YEAR;
        final double numberOfPayments = periodInYrs * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;

    }
}
