package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by helloworld on 2020/2/14.
 * 工具类
 */
public class JDBCUtils {


    /**
     * 编写连接数据库的公共方法
     */
    public static Connection getConn()  {
        ComboPooledDataSource helloc3p0 = new ComboPooledDataSource("helloc3p0");
        Connection connection=null;
        try {
             connection = helloc3p0.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 关闭连接的方法
     */
    public static  void closeResources(ResultSet rs, PreparedStatement pstm,Connection connection){
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pstm !=null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
