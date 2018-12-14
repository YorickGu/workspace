package com.pfuser.responce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Responce 对象的学习:
 *  作用:
 *      用来响应到浏览器的一个对象
 *  使用:
 *      设置响应头
 *      setHeader(String name,String value); //在响应头中添加响应信息，但是同键会被覆盖
 *      addHeader(String name,String value); //在响应头中添加响应信息，但是不会被覆盖
 *      设置响应状态
 *      resp.sendError(404,"sorry");
 *      设置响应编码格式
 *      resp.setContentType("text/xml;charset=utf-8");
 *
 *      设置响应实体
 *
 *      总结:
 *      service请求处理代码流程:
 *      设置响应编码格式
 *      获取请求数据
 *      处理请求数据
 *          数据库操作(MVC思想)
 *      响应处理结果
 *
 * @author guyao
 */

public class ResponceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取请求信息
        //获取请求头
        //获取请求行
        //获取用户数据
        //处理请求

        //响应处理结果
          //设置响应头
        resp.setHeader("mouse","two fly birds!");
        resp.setHeader("mouse","pfuser");
        resp.addHeader("key","thinkpad");
        resp.addHeader("key","lenovo");

        //设置响应编码格式
//        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        resp.setContentType("text/plain;charset=utf-8");
//        resp.setContentType("text/xml;charset=utf-8");
        //html是html文件,而plain是普通文本,就是告诉浏览器,这发过来的就是一个普通文本数据.
        //设置响应状态码
//        resp.sendError(404,"sorry");

        //设置响应实体
         resp.getWriter().write("<b>今天天气真好，适合学习</b>");
    }

}
