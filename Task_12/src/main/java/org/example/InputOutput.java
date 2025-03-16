package org.example;

import org.example.operations.Adder;
import org.example.operations.Divider;
import org.example.operations.Multiplier;
import org.example.operations.Substractor;

import java.util.Scanner;

public class InputOutput
{
    private static final Scanner sc = new Scanner(System.in);

    public static double GetDouble(String message)
    {
        double value = 0;

        while (true)
        {
            System.out.println(message);

            try
            {
                value = sc.nextDouble();
                break;
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
                sc.next();
            }
        }

        return value;
    }

    public static void GetOutput(char operation, double a, double b)
    {
        Calculator calculator;

        switch (operation)
        {
            case '+':
            {
                calculator = new Calculator(new Adder());
                System.out.print("Результат сложения a и b: ");
                calculator.Culc(a, b);
                break;
            }

            case '-':
            {
                calculator = new Calculator(new Substractor());
                System.out.print("Результат вычитания a и b: ");
                calculator.Culc(a, b);
                break;
            }
            case '*':
            {
                calculator = new Calculator(new Multiplier());
                System.out.print("Результат умножения a и b: ");
                calculator.Culc(a, b);
                break;
            }
            case '/':
            {
                if(b == 0)
                {
                    System.out.println("Error divide by zero");
                    return;
                }

                calculator = new Calculator(new Divider());
                System.out.print("Результат деления a и b: ");
                calculator.Culc(a, b);
                break;
            }
        }
    }
}
