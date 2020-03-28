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
				jObject.put("WD", result.getString(5));
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
