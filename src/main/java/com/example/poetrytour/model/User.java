package com.example.poetrytour.model;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {

    private long user_id;
    private String user_tel;
    private String user_name;
    private Timestamp register_time;
    private String user_password;
    private String avatar;
    private String sex;
    private String intro;
    private String collect_post;
}
