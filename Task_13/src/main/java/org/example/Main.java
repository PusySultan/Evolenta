package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main
{
    @Autowired
    Calculator calculator;

    public Main(@Qualifier("calculator") Calculator calculator)
    {
        this.calculator = calculator;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public boolean OutToConsole() throws Exception
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число a");
        double a = in.nextDouble();
        System.out.println("Введите число b");
        double b = in.nextDouble();
        System.out.println("Введите тип операции: " + calculator.getSupportedOperations());
        String operationType = in.next();

        calculator.Calc(operationType, a, b);
        return true;
    }
}