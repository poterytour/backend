package com.example.poetrytour.service;

import com.example.poetrytour.model.User;
import com.example.poetrytour.pojo.Result;

public interface UserService {

    /**
     * 用户登录
     * @param tel
     * @param password
     * @return
     */
    Result<User> login(String tel,String password);


    /**
     * 用户注册
     * @param tel
     * @param password
     * @return
     */
    Result<User> register(String tel,String password);
}
