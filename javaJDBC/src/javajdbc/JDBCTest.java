package javajdbc;

import java.sql.*;

/**
 * Created by gyj on 2018/10/18.
 * 数据库连接
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection con = null;
//        Statement statement = null;
        PreparedStatement perstmt = null;
        ResultSet resultSet = null;
        String driver = "com.mysql.jdbc.Driver";
        //这里我的数据库是pfuser
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        String sql = "select * from orderitems where order_num = ?";
        try {
            //加载驱动，成功加载以后会把Driver类的实例注册到DriverManger类中
            Class.forName(driver);
            //提供JDBC连接的URL，jdbc:mysql://localhost:3306/pfuser
            con = DriverManager.getConnection(url, user, password);

            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }

//          statement = con.createStatement();
            perstmt = con.prepareStatement(sql);

            perstmt.setObject(1, 20005);

//            表格为customers
//            String sql = "select * from orderitems;";
//            resultSet = statement.executeQuery(sql);
            //执行这个sql语句
            resultSet = perstmt.executeQuery();

            String name;
            while (resultSet.next()) {
                name = resultSet.getString("prod_id");
                System.out.println("姓名：" + name);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (perstmt != null) {
                    perstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}