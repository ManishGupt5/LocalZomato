package com.masai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            int preference = 0;
            do {
                System.out.println("=================================================");
                System.out.println("  Welcome to LocalZomaato Console Application!");
                System.out.println("=================================================");
                System.out.println("Please select an option to continue:");
                System.out.println("Who are you !");
                System.out.println("1. Administrator");
                System.out.println("2. Customer");
                System.out.println("3. Restaurant Owner");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
            } while (preference != 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}