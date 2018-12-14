package com.pfuser.Servlet;

import com.pfuser.pojo.User;
import com.pfuser.service.LoginService;
import com.pfuser.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 请求中文乱码解决:
 * 1 使用string进行数据重新编码
 * String uname2 = new String(uname.getBytes("iso8859-1"),"utf-8");
 * 2 使用公共配置
 * get方式
 * 步骤1:req.setCharacterEncoding("utf-8");
 * 步骤2:在tomcat目录下的conf目录中修改server.xml文件,在Connector标签中增加useBodyEncodingForURI= "true"
 * <p>
 * post方式
 * req.setCharacterEncoding("utf-8");
 *
 * Servlet流程总结:
 * 浏览器发起请求到服务器(请求)
 * 服务器接受浏览器的请求,进行解析,并将request对象存储请求数据
 * 服务器调用对应的servlet进行请求处理,并将request对象作为实参传递给servlet的方法
 * servlet的方法执行进行请求处理
 * 设置请求编码格式
 * 设置响应编码格式
 * 获取请求信息
 * 处理请求信息
 * 创建业务层对象
 * 调用业务层对象的方法
 * 响应处理结果
 * <p>
 * 请求转发
 * 作用:实现多个servlet联动操作处理请求,这样会避免代码冗余,让servlet的职责更加明确
 * 使用:req.getRequestDispatcher("要转发的地址").forward(req,resp);
 * 要转发的地址是相对路径,直接书写servlet的别名即可
 * 特点:
 * 一次请求,浏览器地址栏信息不改变
 * 注意:
 * 请求转发后直接return结束即可
 * request作用域：
 * 解决了一次请求内的数据共享问题，setAttribute
 * 重定向：
 * 他解决了表单重复提交的问题以及当前servlet无法处理请求的问题。
 * 使用：
 * resp.sendRedirect(String uri);
 * 实例：
 * resp.sendRedirect("/login/main");
 * 特点：
 * 两次请求，两个request对象
 * 浏览器地址栏信息改变
 * 时机：
 * 如果请求中有两个表单数据，而数据又比较重要，不能重复提交，建议使用重定向
 * 如果请求被接收servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源。
 * <p>
 * 使用servletcontext来实现网站计数器
 * 在用户登陆过程中创建计数器，并且自增，然后存储到servletcontext对象中
 * 在主页面里取出计数器数据显示给用户
 *
 * @author Yorick
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");

        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        /**
         *
         * 获取请求信息
         */
        String uname = req.getParameter("uname");
        //使用String进行重新编码
//        uname = new String(uname.getBytes("iso8859-1"), StandardCharsets.UTF_8);
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);
        //处理请求信息
        //获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname, pwd);
        System.out.println(u);
        //响应处理结果
        if (u != null) {
            //创建cookie信息实现三天免登录。
            Cookie c = new Cookie("uid", u.getUid() + "");
            c.setMaxAge(3 * 24 * 60 * 60);
            c.setPath("/login/ck");
            //添加cookie信息
            resp.addCookie(c);

            HttpSession session = req.getSession();
            session.setAttribute("uname", u.getUname());

            //创建网页计数器，是在原有的基础上进行自增，所以就是先要进行获取
            ServletContext sc = req.getServletContext();
            if (sc.getAttribute("nums") != null){
                int nums = (int) sc.getAttribute("nums");
                //计数器自增
                nums += 1;
                //再次存储到servletcontext对象中
                sc.setAttribute("nums",nums);
            }else {
                sc.setAttribute("nums",1);
            }

//            req.getRequestDispatcher("main").forward(req,resp);
            //重定向
            //重定向的资源的URI，如果是本地资源，就是URI，如果是网络资源，那么就是URL
            resp.sendRedirect("/login/main");
            return;
        } else {
//            resp.getWriter().write("登录失败");
            //使用request对象实现不同servlet的数据流转
            req.setAttribute("str", "用户名或密码错误");
            //使用请求转发
            req.getRequestDispatcher("page").forward(req, resp);
            return;
        }
    }
}
