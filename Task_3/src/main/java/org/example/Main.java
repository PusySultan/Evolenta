package org.example;

public class Main
{
    public static void main(String[] args)
    {
        int a = 0,
                b = 0,
                c = 0;

        System.out.println("Введите 3 числа");
        a = Reader.SetValue(a);
        b = Reader.SetValue(b);
        c = Reader.SetValue(c);

        Reader.ConsoleOutput(a, b, c);

    }
}