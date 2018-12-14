package com.pfuser.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * @program: Login
 * @description: 在服务器启动和关闭时对网页的访问次数的存储和读取
 * @author: Yorick
 * @create: 2018-12-04 16:05
 */
@WebServlet(name = "NumServlet", urlPatterns = "/num",loadOnStartup = 2)
public class NumServlet extends HttpServlet {

    /**
     * Description: 覆写init初始化方法，将数据读取到servletcontext对象中
     *
     * @param: []
     * @return: void
     */
    @Override
    public void init() throws ServletException {
        //获取文件中的计数器数据
        String path = this.getServletContext().getRealPath("/nums/num.txt");
        System.out.println(path);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String number = br.readLine();
            if (number==null){
                this.getServletContext().setAttribute("nums",0);
            }else {
                int nums = Integer.parseInt(number);
                System.out.println(nums);
                this.getServletContext().setAttribute("nums",nums);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Description: 覆写销毁方法，存储计数器到文件中
     *
     * @param: [req, resp]
     * @return: void
     */
    @Override
    public void destroy(){
        //获取网页计数器
        int nums = (int) this.getServletContext().getAttribute("nums");
        System.out.println(nums);
        String path = this.getServletContext().getRealPath("/nums/num.txt");
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(nums+"");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
