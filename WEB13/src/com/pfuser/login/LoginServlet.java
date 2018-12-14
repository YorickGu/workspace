package com.pfuser.login;

import com.pfuser.domain.User;
import com.pfuser.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //从数据库中验证该用户的用户名和密码的正确性
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username =? and password =?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //根据返回的信息给用户显示不同的结果
        if (user !=null){
            //用户登录成功
            resp.getWriter().write("登陆成功！"+user.toString());
        }else {
            //用户登录失败
            resp.getWriter().write("登录失败"+user.toString());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
