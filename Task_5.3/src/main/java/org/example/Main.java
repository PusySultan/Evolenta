package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        SimpleDateFormat inputDatePattern = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputDatePattern = new SimpleDateFormat("yyyy-MM-dd");

        String line = "";

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        line = sc.nextLine();

        try
        {
            date = inputDatePattern.parse(line);
            System.out.println(outputDatePattern.format(date));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}