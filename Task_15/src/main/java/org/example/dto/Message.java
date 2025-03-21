package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Message
{
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;

    public Message()
    {

    }

    public  Message(String title, String text, LocalDateTime time)
    {
        this.title = title;
        this.text = text;
        this.time = time;
    }

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

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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
