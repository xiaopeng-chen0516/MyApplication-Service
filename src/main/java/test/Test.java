package test;


import entity.DataList;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jinpeng_chen
 * @create 2020-03-01 下午 4:03
 **/

public class Test {

    public static void main(String[] args) throws SQLException {

        GetDate getDate=new GetDate();
        Map<Integer,Object>map =getDate.GetData1();

        System.out.println(map);
        System.out.println(map.get(2) );









    }



}
