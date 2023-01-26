package oop_7.CalkJava;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public double getValue(String title) {
        System.out.printf("%s", title);
        return in.nextDouble();
    }

    public int menuCalc() {
        System.out.println("MENU\n" +
                "----------------\n" +
                "1.Addition\n" +
                "2.Substract\n" +
                "3.Multiplication\n" +
                "4.Division\n" +
                "----------------\n" +
                "0.Exit");

        return in.nextInt();
    }

    public void print(double data, String title) {
        System.out.printf("%s %f\n", title, data);
    }
}
