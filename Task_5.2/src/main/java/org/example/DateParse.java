package org.example;

public class DateParse
{
    private String _year;
    private String _mounth;
    private String _day;

    public DateParse(String line)
    {
        try
        {
            String[] date = line.split("\\.");

            _year = date[0];
            _mounth = date[1];
            _day = date[1];
        }
        catch (Exception ignored)
        {}
    }

    public void GetOutputdate()
    {
        System.out.println(_year + '-' + _mounth + '-' + _day);
    }
}