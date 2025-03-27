package org.example;
import org.example.Learner;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudentWithTimer implements Learner
{
    private final Learner learner;

    public StudentWithTimer(Learner learner)
    {
        this.learner = learner;
    }

    @Override
    public void learn()
    {
        learner.learn();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.printf("Текущее время: %s", LocalTime.now().format(formatter));
    }
}