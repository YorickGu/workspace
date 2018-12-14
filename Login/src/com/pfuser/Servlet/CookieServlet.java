package com.pfuser.Servlet;

import com.pfuser.pojo.User;
import com.pfuser.service.LoginService;
import com.pfuser.service.impl.LoginServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @program: Login
 * @description: cookie信息的校验
 * @author: Yorick
 * @create: 2018-12-03 21:35
 * <p>
 * 判断请求信息中是否有携带正确的cookie信息，
 * 如果有，则判断cookie信息是否正确，如果校验正确则直接响应主页面给用户，不正确则响应登陆页面
 * 没有则转发给登陆页面
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/ck",initParams = {
        @WebInitParam(name="config",value = "utf-8")
})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletConfig sc = this.getServletConfig();
        String config = sc.getInitParameter("config");
        System.out.println(config);

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //获取cookie信息
        Cookie[] cks = req.getCookies();
        //处理请求信息
        if (cks != null) {
            //这里面表示的是cookie已经存在，这时候需要对cookie数据进行校验
            //使用uid到数据库中进行查
            String uid = "";
            for (Cookie c : cks) {
                if ("uid".equals(c.getName())) {
                    uid = c.getValue();
                }
                //这个是校验uid是否存在
                if ("".equals(uid)) {
                    //请求转发到登陆页面
                    req.getRequestDispatcher("page").forward(req, resp);
                    return;
                } else {
                    //校验uid用户信息
                    //获取业务层对象
                    LoginService ls = new LoginServiceImpl();
                    User u = ls.checkLoginService(uid);
                    if (u != null) {
                        //直接重定向
                        HttpSession ss = req.getSession();
                        ss.setAttribute("uname",u.getUname());

                        int nums = (int) this.getServletContext().getAttribute("nums");
                        nums += 1;
                        this.getServletContext().setAttribute("nums",nums);
                        //重定向
                        resp.sendRedirect("/login/main");
                        return;

                    } else {
                        //请求转发
                        req.getRequestDispatcher("page").forward(req, resp);
                        return;
                    }
                }
            }
        } else {
            //请求转发
            req.getRequestDispatcher("page").forward(req, resp);
            return;
        }
        //响应处理结果
        //直接响应

        //重定向
    }
}
