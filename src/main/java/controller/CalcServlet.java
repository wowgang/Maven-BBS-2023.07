package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/*")
public class CalcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//doPost()로 포워딩
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (request.getMethod().equals("GET")) {
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/board/calc.jsp");
//			rd.forward(request, response);
//		} 
		
		
		response.setContentType("text/html; charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			String operator = request.getParameter("operator");
			int result = calc(num1, num2, operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		RequestDispatcher rd = request.getRequestDispatcher("/bbs/calc.jsp");
//		rd.forward(request, response);
		
		int result = 0;
		String data = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>계산기</title>"
				+ "</head>"
				+ "<body>"
				+ "    <h2>계산기</h2>"
				+ "    <hr>"
				+ "    <form method=\"post\" action=\"/bbs/CalcServlet\">"
				+ "    	<input type=\"number\" name=\"num1\">"
				+ "		<select name=\"operator\">"
				+ "			<option selected>+</option>"
				+ "			<option>-</option>"
				+ "			<option>*</option>"
				+ "			<option>/</option>"
				+ "		</select>"
				+ "    	<input type=\"number\" name=\"num2\">"
				+ "     <input type=\"submit\" value=\"=\">"
				+ "		 " + result + ""
				+ "    </form>"
				+ "</body>"
				+ "</html>";
		out.print(data);
		
	}
		
		
		public int calc(int num1, int num2, String operator) {
			int result = 0;
			
			if (operator.equals("+")) {
				result = num1 + num2;
				System.out.println(result);
			} else if (operator.equals("-")) {
				result = num1 - num2;
			} else if (operator.equals("*")) {
				result = num1 * num2;
			} else if (operator.equals("/")) {
				result = num1 / num2;
				System.out.println(result);
			}
			return result;
		}
		
		
			
}
