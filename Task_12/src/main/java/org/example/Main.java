package org.example;

public class Main
{
    public static void main(String[] args)
    {
        double a;
        double b;

        a = InputOutput.GetDouble("Введите число a");
        b = InputOutput.GetDouble("Введите число b");

        InputOutput.GetOutput('+', a, b);
        InputOutput.GetOutput('-', a, b);
        InputOutput.GetOutput('*', a, b);
        InputOutput.GetOutput('/', a, b);

    }
}