package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.Test1;

public class NavigateContext extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NavigateContext() {
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
		request.setAttribute("imageAdvertisingOne", Test1.selectAdvertising("7"));
		request.setAttribute("imageAdvertisingTwo", Test1.selectAdvertising("8"));
		request.setAttribute("imageAdvertisingThree", Test1.selectAdvertising("9"));
		List<user.UserOfNavigate> listNavigate1 = Test1.selectNavigationAll("1");
		List<user.UserOfNavigate> listNavigate2 = Test1.selectNavigationAll("2");
		List<user.UserOfNavigate> listNavigate3 = Test1.selectNavigationAll("3");
		List<user.UserOfNavigate> listNavigate4 = Test1.selectNavigationAll("4");
		List<user.UserOfNavigate> listNavigate5 = Test1.selectNavigationAll("5");
		List<user.UserOfNavigate> listNavigate6 = Test1.selectNavigationAll("6");
		List<user.UserOfNavigate> listNavigate7 = Test1.selectNavigationAll("7");
		List<user.UserOfNavigate> listNavigate8 = Test1.selectNavigationAll("8");
		List<user.UserOfNavigate> listNavigate9 = Test1.selectNavigationAll("9");
		List<user.UserOfNavigate> listNavigate10 = Test1.selectNavigationAll("10");
		List<user.UserOfNavigate> listNavigate11 = Test1.selectNavigationAll("11");
		List<user.UserOfNavigate> listNavigate12 = Test1.selectNavigationAll("12");
		List<user.UserOfNavigate> listNavigate13 = Test1.selectNavigationAll("13");
		List<user.UserOfNavigate> listNavigate14 = Test1.selectNavigationAll("14");
		request.setAttribute("list1", listNavigate1);
		request.setAttribute("list2", listNavigate2);
		request.setAttribute("list3", listNavigate3);
		request.setAttribute("list4", listNavigate4);
		request.setAttribute("list5", listNavigate5);
		request.setAttribute("list6", listNavigate6);
		request.setAttribute("list7", listNavigate7);
		request.setAttribute("list8", listNavigate8);
		request.setAttribute("list9", listNavigate9);
		request.setAttribute("list10", listNavigate10);
		request.setAttribute("list11", listNavigate11);
		request.setAttribute("list12", listNavigate12);
		request.setAttribute("list13", listNavigate13);
		request.setAttribute("list14", listNavigate14);

		request.getRequestDispatcher("/JKCJ/jsp/Navigate.jsp").forward(request, response);

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
