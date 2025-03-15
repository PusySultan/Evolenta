package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String name = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Привет, как тебя зовут? ");

        name = sc.next();
        System.out.println("Привет, " + name + "!");
        sc.close();
    }
}