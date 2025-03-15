package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<User> arrayList = new ArrayList<User> ();

        arrayList.add(SetUser(1));
        arrayList.add(SetUser(2));
        arrayList.add(SetUser(3));
        arrayList.add(SetUser(4));
        arrayList.add(SetUser(5));

        Collections.sort(arrayList, new ComparatorPerson());

        for(User user: arrayList)
        {
            System.out.println(user.toString());
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
}