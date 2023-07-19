package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileController
 */
public class FileController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		System.out.println(id);
		List<Part> fileParts = (List<Part>) request.getParts();
		System.out.println(fileParts.size());
		for (Part part: fileParts) {
			String filename = part.getSubmittedFileName();
			if (filename == null)
				System.out.println("filename is null");
			else
				System.out.println(filename);
		}
		
	}

}


