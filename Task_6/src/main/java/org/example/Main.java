package org.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Date firstDate = new Date();
        Calendar firstCalendar = Calendar.getInstance();

        Date secondDate = new Date();
        Calendar secondCalendar = Calendar.getInstance();

        SimpleDateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");

        // input first date
        firstDate = funcDate.InputDate();

        // plus 45 days
        firstCalendar.setTime(firstDate);
        firstCalendar.add(Calendar.DATE, 45);

        System.out.println("Дата после увеличения на 45 дней: "
                + pattern.format(firstCalendar.getTime()));

        // date after shift on begining year
        firstCalendar.setTime(firstDate);
        firstCalendar.add(Calendar.MONTH, - firstDate.getMonth());
        firstCalendar.add(Calendar.DATE, - firstDate.getDate() + 1);

        System.out.println("Дата после сдвига на начало года: "
                + pattern.format(firstCalendar.getTime()));

        // date after plus 10 working day
        firstCalendar.setTime(firstDate);
        firstCalendar = funcDate.plusWorkingDays(firstCalendar, 10);

        System.out.println("Дата после увеличения на 10 рабочих дней: "
                + pattern.format(firstCalendar.getTime()));

        // input first date
        secondDate = funcDate.InputDate();


        secondCalendar.setTime(secondDate);
        firstCalendar.setTime(firstDate);

        // count working day
        int counter = funcDate.CountWorkingDays(firstCalendar, secondCalendar);
        System.out.println("Количество рабочих дней между введенными датами: " + counter);
    }
}