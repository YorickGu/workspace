package JDBCDemo;

import java.sql.*;
/**
 * 本次实验是为了进行一个多条语句的一次性的写入。
 * @author pf_engineering
 * */
public class JdbcDemo {
    public static void main(String[] args) {
        Connection con = null;
        Statement ste = null;
        ResultSet se = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfuser","root","123456");
            //设置数据库的事务为关闭状态
            con.setAutoCommit(false);
            ste = con.createStatement();
            for (int i=0;i<20000;i++){
                ste.addBatch("insert into orderitems(order_num, order_item, prod_id, quantity, item_price)" +
                        "values (20009,"+i+5+",'JP2000',2,18.20)");
            }

            ste.executeBatch();
            con.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
