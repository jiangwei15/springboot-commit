package com.kuang.controller;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();

        for (User user : users) {
            System.out.println(user);
        }

        return users;
    }

    // 添加一个用户
    @RequestMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(null, "阿毛", "456789"));
        return "ok!";
    }

    // 修改一个用户
    @RequestMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(4, "小阿毛", "456789"));
        return "ok!";
    }

    // 添加一个用户
    @RequestMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(5);
        return "ok!";
    }
}
