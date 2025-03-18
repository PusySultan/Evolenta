package org.example.dto;

import java.time.LocalDateTime;

public class Message
{
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;

    public Message(int id, String title, String text, LocalDateTime time)
    {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public int getId()
    {
        return id;
    }

    public LocalDateTime getTime()
    {
        return time;
    }

    public String getText()
    {
        return text;
    }

    public String getTitle()
    {
        return title;
    }
}
