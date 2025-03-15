package org.example;

import java.util.Scanner;

public class Reader
{
    public static int SetValue(int value)
    {
        boolean erroFlag = false;

        Scanner sc = new Scanner(System.in);

        do
        {
            try
            {
                value = sc.nextInt();

                erroFlag = false;
            }
            catch (Exception ex)
            {
                System.out.println( " error : " + ex.getMessage());
                sc.next();

                erroFlag = true;
            }

        } while (erroFlag);

        return value;
    }

    public static void ConsoleOutput(int a, int b ,int c)
    {
        double res = (double) a / (double) b;

        DivideBy5(a, b, c);
        System.out.println("Результат целочисленного деления a на b: " + a / b);
        System.out.println("Результат деления a на b: " + res);
        System.out.println("Результат деления a на b с округлением в большую сторону: " + (int) Math.ceil(res));
        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + (int) Math.floor(res));
        System.out.println("Результат деления a на b с математическим округлением: " + (int) Math.round(res));
        System.out.println("Остаток от деления b на c: " + b % c);
        System.out.println("Наименьшее значение из a и b: " + Math.min(a, b));
        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));
    }

    private static void DivideBy5(int a, int b ,int c)
    {
        boolean flag = false;

        if(a % 5 == 0)
        {
            System.out.println("a = " + a);
            flag = true;
        }

        if(b % 5 == 0)
        {
            System.out.println("b = " + b);
            flag = true;
        }

        if(c % 5 == 0)
        {
            System.out.println("c = " + c);
            flag = true;
        }

        if(!flag)
        {
            System.out.println("There are no multiples of 5");
        }


    }
}