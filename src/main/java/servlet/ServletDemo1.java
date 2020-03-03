package servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDemo1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "SELECT *FROM detection WHERE id=(SELECT MAX(id) FROM detection)";
		JSONArray jsonArray=new JSONArray(); //json数组
		try {
			ResultSet result = DatabaseUtil.query(sql);
			while (result.next()) {
				JSONObject jObject=new JSONObject();  //json临时对象
				jObject.put("id", result.getInt(1));
				jObject.put("O2", result.getString(2));
				jObject.put("CO2", result.getString(3));
				jsonArray.add(jObject);   //将封装好的json对象放入json数组
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	    String jsondata=jsonArray.toString();  //将json数组转换成字符串，供下面返回给android端使用
		System.out.println(jsondata);  //本地测试用
		response.getWriter().append(jsondata).flush();
	}
}
