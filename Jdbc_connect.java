package MyCode; /**
 * 练习一-----连接jdbc，进行简单的查询
 */

import java.sql.*;
import java.util.*;

import static java.lang.Class.forName;

/**
 *
 */


public class Jdbc_connect {

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }

        catch(Exception e){
            System.out.println("注册驱动失败");
        }
    }


    public static void main(String[] args) throws Exception{

        String url="jdbc:mysql://localhost:3306/new_schema";
        String user="root";
        String password="00134163i";
        //通过驱动获得数据库连接
        Connection con=DriverManager.getConnection(url,user,password);

        try{
            //获得Statement用来操作数据库
            Statement stmt=con.createStatement();
            //写sql语句
            String sql="select * from roomnum";
            //获得结果集
            ResultSet rs=stmt.executeQuery(sql);
            //输出结果
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException s){
            System.out.println(s.getSQLState()+s.getErrorCode());
        }finally {

            con.close();


        }


    }
}
