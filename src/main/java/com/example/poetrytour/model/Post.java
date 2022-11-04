package com.example.poetrytour.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Post {


    private long post_id;
    private String post_title;
    private String post_context;
    private long user_id;
    private Timestamp post_time;
    private int post_love;
    private int post_reading;
    private int post_collect;
    private String pronvice;
    private String city;
    private String attraction;
}
