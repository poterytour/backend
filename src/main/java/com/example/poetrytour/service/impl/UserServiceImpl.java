package com.example.poetrytour.service.impl;

import com.example.poetrytour.dao.UserDAO;
import com.example.poetrytour.model.User;
import com.example.poetrytour.pojo.Result;
import com.example.poetrytour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public Result<User> login(String tel, String password) {
        Result<User> result=new Result<>();
        User user=userDAO.getUserByTel(tel);
        if(user==null){
            result.setSuccess(false);
            result.setMessage("该手机号尚未注册");
            result.setCode("400");
            return result;
        }else {
            if(user.getUser_password().equals(password)){
                result.setSuccess(true);
                result.setCode("200");
                result.setMessage("登录成功");
                result.setData(user);
                return result;
            }else {
                result.setSuccess(false);
                result.setCode("401");
                result.setMessage("账号或密码错误");
                return result;
            }
        }
    }

    @Override
    public Result<User> register(String tel, String password) {
        Result<User> result=new Result<>();
        int rs=0;
        if(userDAO.getUserByTel(tel)==null){
            Timestamp time=new Timestamp(System.currentTimeMillis());
            String str=tel.substring(tel.length()-4);
            String id=time.getTime()/1000+str;
            rs= userDAO.register(Long.parseLong(id), tel, password,time);
        }
        if(rs==1){
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("注册成功");
            result.setData(userDAO.getUserByTel(tel));
            return result;
        }else {
            result.setSuccess(false);
            result.setCode("400");
            result.setMessage("该号码已注册，请登录");
            return result;
        }

    }
}
