package com.company;

import java.util.Scanner;

public class Console {
    public static double userPrompt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(message);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.print("Enter a number between " + min + " and " + max + ".\n");
        }
        return value;
    }
}
