package com.example.tryf.controller;


import com.example.tryf.dao.UserDao;
import com.example.tryf.model.User;
import com.example.tryf.utill.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserDao userDao;
    @PostMapping("/logup")
    public Object logup(String username,String password,String sex){

        User user = userDao.findByUsername(username);

        if(user==null){
            user = new User();
            user.setUsername(username);
            user.setPassword(MD5.getMD5(password));
            user.setSex(sex);
            userDao.save(user);

            return "注册成功";
        }

        return "你已成功注册!";
    }
    @PostMapping("/login")
    public Object login(String username,String password){


        User user = userDao.findByUsername(username);
        if(user==null){
            return "用户名有问题";
        }
        if(user.getPassword().equals(MD5.getMD5(password))){
            httpSession.setAttribute("user",user);
            return "登陆成功";
            //httpSession.removeAttribute("user");
        }else {
            return "你的密码有问题";
        }
    }


}
