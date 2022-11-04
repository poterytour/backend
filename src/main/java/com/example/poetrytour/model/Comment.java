package com.example.poetrytour.model;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {

    private long com_id;
    private String com_context;
    private Timestamp com_time;
    private long parent_com_id;
    private long user_id;
    private long post_id;
    private int com_love;
}
