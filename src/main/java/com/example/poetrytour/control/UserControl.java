package com.example.poetrytour.control;


import com.example.poetrytour.dao.CommentDAO;
import com.example.poetrytour.dao.PostDAO;
import com.example.poetrytour.dao.UserDAO;
import com.example.poetrytour.model.Comment;
import com.example.poetrytour.model.Post;
import com.example.poetrytour.model.User;
import com.example.poetrytour.pojo.Result;
import com.example.poetrytour.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class UserControl {

    @Autowired
    private UserDAO userDAO;



    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("user/getById")
    public User getUserById(@Param("id") long id){
        return userDAO.getUserById(id);
    }


    @ResponseBody
    @RequestMapping("user/getByTel")
    public User getUserByTel(@Param("tel") String tel){
        return userDAO.getUserByTel(tel);
    }

    @ResponseBody
    @RequestMapping("user/register")
    public Result<User> register(@Param("tel") String tel, @Param("password") String password){
        return userService.register(tel,password);
    }

    @ResponseBody
    @RequestMapping("user/login")
    public Result<User> login(@Param("tel") String tel, @Param("password") String password){
        return userService.login(tel, password);
    }


}
