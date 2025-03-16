package org.example.operations;

import org.example.Operation;

public class Multiplier implements Operation
{
    @Override
    public double getResulte(double a, double b)
    {
        return a * b;
    }
}
