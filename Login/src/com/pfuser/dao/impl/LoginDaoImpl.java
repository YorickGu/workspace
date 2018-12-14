package com.pfuser.dao.impl;

import com.pfuser.dao.LoginDao;
import com.pfuser.pojo.User;

import java.sql.*;


public class LoginDaoImpl implements LoginDao {

    @Override
    public User ckeckLoginDao(String uname, String pwd) {
        //创建jdbc对象，或者叫jdbc声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root", "123456");
            //创建sql命令
            String sql = "select * from t_user where uname = ? and pwd = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //返回
        return u;
    }

    /**
     * Description: 根据uid来获取用户信息
     * @param: [uid]
     * @return: com.pfuser.pojo.User
     */
    @Override
    public User checkUidDao(String uid) {

        //创建jdbc对象，或者叫jdbc声明
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root", "123456");
            //创建sql命令
            String sql = "select * from t_user where uid = ? ";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, uid);
            //执行
            rs = ps.executeQuery();

            //遍历执行结果
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //返回
        return u;
    }

}
