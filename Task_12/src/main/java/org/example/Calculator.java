package org.example;

public class Calculator
{
    Operation operation;

    public Calculator(Operation operation)
    {
        this.operation = operation;
    }

    public void Culc(double a, double b)
    {
        double resulte;

        try
        {
            resulte = operation.getResulte(a, b);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(operation.getResulte(a ,b));
    }
}
