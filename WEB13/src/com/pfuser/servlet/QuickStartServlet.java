package com.pfuser.servlet;

import com.sun.xml.internal.ws.api.config.management.Reconfigurable;

import javax.servlet.*;
import java.io.IOException;

public class QuickStartServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取servlet的name     <servlet-name>QuickStartServlet</servlet-name>
        //获取该servlet的初始化的一些参数
        String getParameter = servletConfig.getInitParameter("url");
        System.out.println(getParameter);
        //获取Servletcontext对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
        System.out.println("init is running");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("QuickStartServlet running ");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory is running");
    }
}
