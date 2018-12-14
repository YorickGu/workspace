package com.pfuser.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    /**
     * Description: 这是在覆写service方法，从而展示主页面的操作
     * @param: [req, resp]
     * @return: void
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置相应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        HttpSession ss = req.getSession();
        int nums = (int) this.getServletContext().getAttribute("nums");

        //处理请求信息
        //响应处理结果
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+ss.getAttribute("uname")+"访问我的主页</h3>");
        resp.getWriter().write("当前网页浏览次数为"+nums);
        resp.getWriter().write("<hr>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
