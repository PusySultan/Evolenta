package org.example;

import java.util.HashMap;
import java.util.Map;

public class Output
{
    public static void Output(int[] array)
    {
        array = CreateArray(array);
        OutputArray(array);

        OutputDublicate(FindeDublicat(array));
    }

    private static int[] CreateArray(int[] array)
    {
        for (int i = 0; i < 20; i++)
        {
            array[i] = (int)(Math.random() * 20);
        }

        return array;
    }

    private static void OutputArray(int[] array)
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    private  static void OutputDublicate(HashMap<Integer, Integer> dublicate)
    {
        for (Map.Entry<Integer, Integer> item : dublicate.entrySet())
        {
            System.out.println("Число " + item.getKey() + " встречается: "
                    + item.getValue() + " раза");
        }
    }

    // key - value, value - count
    private static HashMap <Integer,Integer> FindeDublicat(int[] array)
    {
        HashMap <Integer, Integer> dublicate = new HashMap<>();
        int value = array[0];

        for (int i = 0; i < 20; i++)
        {
            value = array[i];
            if(dublicate.containsKey(value))
            {
                continue;
            }

            for (int j = 0; j < 20; j++)
            {
                if(value == array[j] && i != j && !dublicate.containsKey(value))
                {
                    dublicate.put(value, 2);
                    continue;
                }

                if(value == array[j] && i != j && dublicate.containsKey(value))
                {
                    dublicate.replace(value, dublicate.get(value) + 1);
                }
            }
        }

        return dublicate;
    }
}