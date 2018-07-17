package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.Test1;
import user.UserOfCoin;

public class CoinContext extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CoinContext() {
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
		List<user.UserOfGolden> listGoldensub = Test1.selectGoldenSub(6);
		List<user.UserOfCoin> listCoinsub = Test1.selectCoinSub(6);
		UserOfCoin userOfCoin = Test1.selectCoin(request.getParameter("id").trim());

		String ud[] = Test1.selectCoinUD(request.getParameter("id").trim());
		UserOfCoin userOfCoin1 = Test1.selectCoin(ud[0]);
		UserOfCoin userOfCoin2 = Test1.selectCoin(ud[1]);

		if (ud[0] != null) {
			userOfCoin1 = Test1.selectCoin(ud[0]);
		} else {
			userOfCoin1 = Test1.selectCoin(request.getParameter("id").trim());
		}
		if (ud[1] != null) {
			userOfCoin2 = Test1.selectCoin(ud[1]);
		} else {
			userOfCoin2 = Test1.selectCoin(request.getParameter("id").trim());
		}
		request.setAttribute("imageAdvertisingOne", Test1.selectAdvertising("4"));
		request.setAttribute("imageAdvertisingTwo", Test1.selectAdvertising("5"));
		request.setAttribute("imageAdvertisingThree", Test1.selectAdvertising("6"));
		request.setAttribute("coin11", userOfCoin1);
		request.setAttribute("coin22", userOfCoin2);
		request.setAttribute("coin", userOfCoin);

		request.setAttribute("quick", listGoldensub);
		request.setAttribute("coin1", listCoinsub);
		Test1.updateCoin(request.getParameter("id").trim(), (userOfCoin.getLook() + 1));

		request.getRequestDispatcher("/JKCJ/jsp/coinContext.jsp").forward(request, response);
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
