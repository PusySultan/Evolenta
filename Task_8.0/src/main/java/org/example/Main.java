package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        int age = -1;

        HashMap<Integer, List<User>> map = GetMap();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите требуемый возраст");

        try
        {
            age = Integer.parseInt(sc.nextLine());
        }
        catch (Exception ex)
        {
            sc.next();
            System.out.println(ex.getMessage());
        }

        if(map.containsKey(age))
        {
            for (User user: map.get(age))
            {
                System.out.println(user.toString());
            }
        }
        else
        {
            System.out.println("Пользователь с возрастом '" + age +  "' не найден");
        }
    }

    private static User SetUser(int counter)
    {
        int age;
        String name;

        Scanner sc = new Scanner(System.in);
        User user = null;

        System.out.println("Введите имя пользователя " + counter);
        name = sc.nextLine();

        while (true)
        {
            System.out.println("Введите возраст пользователя " + counter);

            try
            {
                age = Integer.parseInt(sc.nextLine());
                user = new User(name, age);
                break;
            }
            catch (Exception ex)
            {
                sc.next();
                System.out.println(ex.getMessage());
            }
        }

        return user;
    }

    private static HashMap<Integer, List<User>> GetMap()
    {
        int counter = 1;
        HashMap<Integer, List<User>> map =  new HashMap<>();

        while (counter < 6)
        {
            User user = SetUser(counter);

            if(map.containsKey(user.getAge()))
            {
                map.get(user.getAge()).add(user);
            }
            else
            {
                List<User> list = new ArrayList<User>();
                list.add(user);

                map.put(user.getAge(), list);
            }

            counter++;
        }

        return map;
    }
}