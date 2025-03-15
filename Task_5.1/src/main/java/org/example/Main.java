package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        String line = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку");

        line = sc.nextLine();
        line = FindebadWords(line);

        System.out.println(line);
    }

    private static String FindebadWords(String line)
    {
        line = line.replace("кака", "вырезано цензурой");
        line = line.replace("бяка", "вырезано цензурой");

        return line;
    }
}