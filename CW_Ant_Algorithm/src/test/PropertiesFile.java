package test;

import java.io.*;
import java.util.*;

/**
 * @author guyao
 */
public class PropertiesFile {
    public static void main(String[] args) {
        Properties settings = new Properties();
        try {
            settings.load(new FileInputStream("E:\\test\\count.java"));
        } catch (Exception e) {
            settings.setProperty("count", new Integer(0).toString());
        }
        int c = Integer.parseInt(settings.getProperty("count")) + 1;
        System.out.println("这是本程序第" + c + "次被使用");
        settings.put("count", new Integer(c).toString());
        try {
            settings.store(new FileOutputStream("E:\\test\\count.java"), "PropertiesFile use it.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
