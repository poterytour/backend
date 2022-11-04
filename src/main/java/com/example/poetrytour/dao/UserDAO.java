package com.example.poetrytour.dao;


import com.example.poetrytour.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface UserDAO {

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 根据电话查找用户
     * @param tel
     * @return
     */
    User getUserByTel(String tel);

    /**
     *
     * @param id
     * @param tel
     * @param password
     * @return
     */
    int register(long id, String tel, String password, Timestamp time);

}
