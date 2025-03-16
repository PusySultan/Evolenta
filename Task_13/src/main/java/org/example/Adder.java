package org.example;

import org.example.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Adder implements Operation
{
    @Override
    public double getResult(double a, double b)
    {
        return a + b;
    }
}
