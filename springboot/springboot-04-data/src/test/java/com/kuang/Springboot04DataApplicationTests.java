package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        // 查看以下默认的数据源：com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        // 获得数据库链接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        // xxxxTemplate：SpringBoot 已经配置好的模板bean，拿来即用 CRUD

        // 关闭连接
        conn.close();
    }

}
