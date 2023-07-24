package controller;

/*
 * city table에 대해서 다음의 기능을 하는 서블릿을 만드세요.
1. 국내 도시중 인구수가 많은 Top 10 도시 리스트를 보여주는 화면 (10점)
2. 도시 이름을 파라메터로 받아서 도시의 정보를 보여주는 화면. (10점)
3. 도시 정보를 추가 (10점)
4. 도시 정보를 수정 (10점)
5. 도시를 삭제(10점)
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Citytable
 */
public class Citytable extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
