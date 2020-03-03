package servlet;


import entity.DataList;
import test.GetDate;
import util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 请求处理
 *
 * @author jinpeng_chen
 * @create 2020-02-25 下午 11:04
 **/

public class MyHttpServlet extends HttpServlet {
    public MyHttpServlet() {
    }

    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了doGet");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //得到手机端发来的GET请求（包含参数）
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        username = new String(username.getBytes("UTF-8"), "UTF-8");
        password = new String(password.getBytes("UTF-8"), "UTF-8");
        System.out.print("姓名" + username);
        System.out.println("密码" + password);
        String name="密码"+username;
        if (username.equals("111") && password.equals("111")) {

            //默认情况下使用的是iso8859——1编码，但是如果发现码表中没有当前字符，会使用当前系统下默认编码：GBK
//            resp.getOutputStream().write("登录成功".getBytes("utf-8"));
            resp.getOutputStream().write(name.getBytes("UTF-8"));
        } else {
            resp.getOutputStream().write("登录失败".getBytes("UTF-8"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了doPost");
        DataList dataList=new DataList();
        GetDate getDate =new GetDate() ;

        Map<Integer,Object > map =getDate .GetData1();
//        resp.getOutputStream().print(String.valueOf(map));
        resp.getWriter().print(map);
//        System.out.println(map);
//        resp.getOutputStream().write(list.toString().getBytes("UTF-8"));
//        PreparedStatement pstm = null;
//        ResultSet resultSet = null;
//        Connection connection = null;
//
//        connection= JDBCUtils.getConn();
//        String sql="SELECT *FROM detection WHERE id=(SELECT MAX(id) FROM detection)";
//
//        try {
//            pstm=connection.prepareStatement(sql);
//            resultSet=pstm.executeQuery();
//            while (resultSet.next()){
//                String data = "id" + resultSet.getInt("id")
//                        + "O2" + resultSet.getString("O2")
//                        + "CO2" + resultSet.getString("CO2");
//                resp.getOutputStream().write(data.getBytes("UTF-8"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtils.closeResources(resultSet,pstm,connection);
//        }

    }
}
