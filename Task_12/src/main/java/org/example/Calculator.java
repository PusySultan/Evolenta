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
            System.out.println(resulte);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
