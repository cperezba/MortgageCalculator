package com.company;

import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int principal = (int) Console.userPrompt("Principal ($1k - $1M): ", 1_000, 1_000_000);
        float annualRate = (float) Console.userPrompt("Annual Interest Rate (1 - 30): ", 1, 30);
        byte periodInYrs = (byte) Console.userPrompt("Period(Years) (1 - 30): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualRate, periodInYrs);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }


}
