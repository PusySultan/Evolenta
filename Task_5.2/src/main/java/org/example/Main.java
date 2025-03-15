package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        DateParse dp =null;
        Scanner sc = new Scanner(System.in);
        String date = "";

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        date = sc.nextLine();

        dp = new DateParse(date);
        dp.GetOutputdate();
    }
}