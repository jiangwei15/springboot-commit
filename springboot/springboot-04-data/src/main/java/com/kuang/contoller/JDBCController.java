package com.kuang.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user values (4, '小明', '123456')";
        jdbcTemplate.update(sql);
        return "addUser ok！";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id) {
        // 预编译模板 ？
        String sql = "update mybatis.user set name = ?, password = ? where id = " + id;

        // 封装
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zzzzzzzzz";
        jdbcTemplate.update(sql, objects);
        return "updateUser ok！";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        // 预编译模板 ？
        String sql = "delete from mybatis.user where id = ?";

        jdbcTemplate.update(sql, id);
        return "deleteUser ok！";
    }
}
