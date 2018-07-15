package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.Test1;
import user.UserOfPolicy;

public class PolicyContext extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PolicyContext() {
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
		// List<user.UserOfGolden> listGolden = Test1.selectGoldenAll();
		// request.setAttribute("news", listGolden);
		// request.getSession().setAttribute("news", listGolden);
		List<user.UserOfGolden> listGoldensub = Test1.selectGoldenSub(6);
		List<user.UserOfCoin> listCoinsub = Test1.selectCoinSub(6);
		UserOfPolicy userOfPolicy = Test1.selectPolicy(request.getParameter("id").trim());
		String ud[] = Test1.selectPolicyUD(request.getParameter("id").trim());
		UserOfPolicy userOfPolicy1;
		System.out.println(ud[0] + "   " + ud[1]);
		if (ud[0] != null) {
			userOfPolicy1 = Test1.selectPolicy(ud[0]);
		} else {
			userOfPolicy1 = Test1.selectPolicy(request.getParameter("id").trim());
			// userOfPolicy1.setTitle("没有最新的消息了\r" + userOfPolicy1.getTitle());
		}
		UserOfPolicy userOfPolicy2 = null;
		if (ud[1] != null) {
			userOfPolicy2 = Test1.selectPolicy(ud[1]);
		} else {
			userOfPolicy2 = Test1.selectPolicy(request.getParameter("id").trim());
			// userOfPolicy2.setTitle("暂无更多消息");
		}
		request.setAttribute("policy", userOfPolicy);
		request.setAttribute("policy1", userOfPolicy1);
		request.setAttribute("policy2", userOfPolicy2);
		request.setAttribute("quick", listGoldensub);
		request.setAttribute("coin", listCoinsub);
		request.setAttribute("imageAdvertisingOne", Test1.selectAdvertising("4"));
		request.setAttribute("imageAdvertisingTwo", Test1.selectAdvertising("5"));
		request.setAttribute("imageAdvertisingThree", Test1.selectAdvertising("6"));

		Test1.updatePolicy(request.getParameter("id").trim(), (userOfPolicy.getLook() + 1));
		// System.out.println(listGolden.size());
		request.getRequestDispatcher("/JKCJ/jsp/policyContext.jsp").forward(request, response);
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
