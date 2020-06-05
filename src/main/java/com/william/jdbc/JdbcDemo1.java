package com.william.jdbc;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?characterEncoding=UTF-8&serverTimezone=UTC", "root", "123456");
        //获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //执行SQL，获得结果集
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
