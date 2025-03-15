package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class funcDate
{
    public static Date InputDate()
    {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("Введите дату в формате dd.MM.yyyy:");

        try
        {
            String inputLine = sc.nextLine();
            date = pattern.parse(inputLine);
        }
        catch (ParseException ex)
        {
            System.out.println("input string has been uncorrect");
        }

        return date;
    }

    public static int CountWorkingDays(Calendar firstCalendar,
                                       Calendar secondCalendar)
    {
        int counter = 0;

        if(firstCalendar.after(secondCalendar))
        {
            do
            {
                secondCalendar.add(Calendar.DATE, 1);
                if(secondCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                        secondCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
                {
                    counter++;
                }

            }
            while (!secondCalendar.equals(firstCalendar));

            return counter;
        }

        if(secondCalendar.after(firstCalendar))
        {
            do
            {
                firstCalendar.add(Calendar.DATE, 1);
                if(firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                        firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
                {
                    counter++;
                }
            }
            while (!secondCalendar.equals(firstCalendar));

            return counter;
        }

        return 0;
    }

    public static Calendar plusWorkingDays(Calendar firstCalendar, int count)
    {
        int counter = 0;

        while (counter < count)
        {
            firstCalendar.add(Calendar.DATE, 1);

            if(firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    firstCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
            {
                counter++;
            }
        }

        return firstCalendar;
    }
}