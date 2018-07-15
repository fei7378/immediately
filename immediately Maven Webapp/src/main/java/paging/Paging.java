package paging;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.alibaba.fastjson.JSON;

import databases.Test1;
import user.UserOfGolden;
import user.UserOfPolicy;

public class Paging extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Paging() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Test1.selectGoldenNum(0, 10);
		// JSON.toJSON(Test1.selectGoldenNum(0, 10));

		int typenum = Integer.valueOf(request.getParameter("type")).intValue();

		Map<String, Object> data = new HashedMap();
		if (typenum == 1) {
			int num = Test1.selectGoldenAllNum();
			if ((num - 10) % 10 != 0) {
				num = num / 10 + 1;
			} else {
				num = num / 10;
			}

			int page = Integer.valueOf(request.getParameter("page")).intValue();
			System.out.println("page1" + page);
			if (num > page) {
				List<UserOfGolden> golden = Test1.selectGoldenNum((page - 1) * 10, page * 10);
				for (UserOfGolden userOfGolden : golden) {

					// System.out.println(stampToDate(userOfGolden.getCreated_id()
					// +
					// "000"));
					userOfGolden.setTime(stampToDate(userOfGolden.getCreated_id() + "000"));

				}

				data.put("data", golden);
				data.put("code", num);

			} else {
				System.out.println("1没有了");
				data.put("code", -1);
			}

		} else if (typenum == 2) {

			int num = Test1.selectPolicyAllNum();
			if ((num - 10) % 10 != 0) {
				num = num / 10 + 1;
			} else {
				num = num / 10;
			}

			int page = Integer.valueOf(request.getParameter("page")).intValue();
			System.out.println("page2" + page);
			if (num > page) {
				List<UserOfPolicy> golden = Test1.selectPolicyNum((page - 1) * 10, page * 10);
				for (UserOfPolicy userOfPolicy : golden) {

					// System.out.println(stampToDate(userOfGolden.getCreated_id()
					// +
					// "000"));
					userOfPolicy.setSource(stampToDate(userOfPolicy.getPublished_at() + "000"));

				}

				data.put("data", golden);
				data.put("code", num);

			} else {
				System.out.println("2没有了");
				data.put("code", -1);
			}

		}
		response.getWriter().print(JSON.toJSON(data));
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
