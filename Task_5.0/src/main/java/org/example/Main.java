package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        String line = "";
        String subLine = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку");
        line = sc.nextLine();

        System.out.println("Введите подстроку");
        subLine = sc.nextLine();

        FindeOutput(line, subLine);

    }

    public static void FindeOutput(String line, String subLine)
    {
        int startIndex = 0;
        int counter = 0;

        while ((startIndex = line.indexOf(subLine, startIndex)) != -1)
        {
            startIndex += subLine.length();
            counter++;
        }

        System.out.println("Подстрока " + subLine + " встречается " + counter + " раза");
    }
}