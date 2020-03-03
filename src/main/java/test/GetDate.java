package test;

import entity.DataList;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jinpeng_chen
 * @create 2020-03-01 下午 5:58
 **/

public class GetDate {
    DataList dataList=null;
    
    public Map<Integer, Object> GetData1(){
        Map<Integer,Object> result=new HashMap<Integer, Object>();

        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        Connection connection = null;

        connection= JDBCUtils.getConn();
        String sql="SELECT *FROM detection WHERE id=(SELECT MAX(id) FROM detection)";

        try {
            pstm=connection.prepareStatement(sql);
            resultSet=pstm.executeQuery();
            while (resultSet.next()){
                dataList=new DataList();
                dataList.setId(resultSet.getInt("id"));
                dataList.setO2(resultSet.getDouble("O2") );
                dataList.setCO2(resultSet.getDouble("CO2") );

                result.put(1,resultSet.getInt("id"));
                result.put(2,resultSet.getDouble("O2") );
                result.put(3,resultSet.getDouble("CO2") );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResources(resultSet,pstm,connection);
        }
        return result;
    }
}
