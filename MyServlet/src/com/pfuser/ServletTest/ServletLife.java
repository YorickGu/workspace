package com.pfuser.ServletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLife",urlPatterns = {"/life"})
public class ServletLife extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("servlet 初始化完成");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().write("resp is running ");
        System.out.println("running");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost running");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet running");
    }

    @Override
    public void destroy() {
        System.out.println("我被销毁了");
    }
}
