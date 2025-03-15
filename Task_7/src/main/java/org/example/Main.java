package org.example;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        User user_1 = null;
        User user_2 = null;

        String name;
        int age;

        System.out.println("Введите имя первого пользователя");
        name = sc.nextLine();

        System.out.println("Введите возраст первого пользователя");

        try
        {
            age = Integer.parseInt(sc.nextLine());
            user_1 = new User(name, age);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        System.out.println("Введите имя второго пользователя");
        name = sc.nextLine();

        System.out.println("Введите возраст второго пользователя");

        try
        {
            age = Integer.parseInt(sc.nextLine());
            user_2 = new User(name, age);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        ToString(GetMinAgeUser(user_1, user_2));
    }

    private static User GetMinAgeUser(User user_1, User user_2)
    {
        return user_1.getAge() < user_2.getAge() ? user_1 : user_2;
    }

    private static void ToString(User user)
    {
        System.out.println(user.toString());
    }
}