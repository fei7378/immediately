package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.Test1;

public class HomePage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HomePage() {
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
	 *             if ans error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<user.UserOfGolden> listGolden = Test1.selectGoldenNum(0, 10);
		// 放入广告图片
		String one;
		if (Test1.selectAdvertising("1") == null) {
			one = "/JKCJ/images/adv-1.png";
		} else {
			one = Test1.selectAdvertising("1");
		}
		String two;
		if (Test1.selectAdvertising("1") == null) {
			two = "JKCJ/images/adv_3.png";
		} else {
			two = Test1.selectAdvertising("2");
		}
		request.setAttribute("imageAdvertisingOne", one);
		request.setAttribute("imageAdvertisingTwo", two);
		request.setAttribute("imageAdvertisingThree", Test1.selectAdvertising("3"));
		request.setAttribute("news", listGolden);
		System.out.println(listGolden.size());
		request.getRequestDispatcher("/JKCJ/jsp/home.jsp").forward(request, response);

		// request.getSession().setAttribute("news", listGolden);
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01
		// Transitional//EN\">");
		// out.println("<HTML>");
		// out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println(" <BODY>");
		// out.print(" This is ");
		// out.print(this.getClass());
		// out.println(", using the GET method");
		// out.println(" </BODY>");
		// out.println("</HTML>");
		// out.flush();
		// out.close();
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
