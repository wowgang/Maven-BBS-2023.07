package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import db.BoardDao;
import db.ReplyDao;
import db.UserDao;
import entity.Board;
import entity.Reply;
import utillity.JsonUtil;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,	// 1 MB
		maxFileSize = 1024 * 1024 * 10, 		// 10 MB
		maxRequestSize = 1024 * 1024 * 10
)
public class BoardController extends HttpServlet {
	public static final int LIST_PER_PAGE = 10; // 한 페이지당 글 목록의 개수
	public static final int PAGE_PER_SCREEN = 10; // 한 화면에 표시되는 페이지 개수
	public static final String UPLOAD_PATH ="c:/Temp/upload/";
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length -1];
		HttpSession session = request.getSession();
		session.setAttribute("menu", "board");	// common폴더 top.jspf li태그 부분
		String sessionUid = (String) session.getAttribute("uid");
		BoardDao bDao = new BoardDao();
		ReplyDao rDao = new ReplyDao();
		JsonUtil ju = new JsonUtil();

		RequestDispatcher rd = null;
		// 공통변수
		int bid = 0, page = 0;
		String title = null, content = null, files = null, uid = null;
		Board board = null;
		
		switch (action) {
		case "list":
			String page_ = request.getParameter("p"); 
			String field = request.getParameter("f"); 
			String query = request.getParameter("q"); 
			page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			field = (field == null || field.equals("")) ? "title" : field;
			query = (query == null || query.equals("")) ? "" : query;
			
			List<Board> list = bDao.listBoard(field, query, page);
			// 페이징 구현 startpage endpage
			// 1 10	startpage-1  endpage+1
			// 11 15
			// totalpage = 15 // page = 10 // page => 11
			int totalBoardCount = bDao.getBoardCount(field, query); 
			int totalPages = (int) Math.ceil(totalBoardCount / (double) LIST_PER_PAGE);
			int startPage = (int) Math.ceil((page-0.5)/PAGE_PER_SCREEN -1) * PAGE_PER_SCREEN + 1;
			int endPage = Math.min(totalPages, startPage + PAGE_PER_SCREEN - 1);
			List<String> pageList = new ArrayList<String>();
			for (int i = startPage; i <= endPage; i++)
				pageList.add(String.valueOf(i));
			
			// 클라이언트로 값 내려보내기 
			session.setAttribute("currentBoardPage", page);
			request.setAttribute("boardList", list);
			request.setAttribute("field", field);
			request.setAttribute("query", query);
			request.setAttribute("today", LocalDate.now().toString());
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageList", pageList);
			
			
			rd = request.getRequestDispatcher("/WEB-INF/view/board/list.jsp");
			rd.forward(request, response);
			break;
		case "detail":
			// parameter를 받을 경우 추가 / 데이터를 읽은 후 로직에 따라 조회수 증가
			bid = Integer.parseInt(request.getParameter("bid"));
			uid = request.getParameter("uid");
			String option = request.getParameter("option");
			// 본인이 조회한 경우 또는 댓글 작성후에는 조회수를 증가시키지 않음
			if (!uid.equals(sessionUid) && (option==null || option.equals(""))  ) // sessionUid로그인 한사람 따라서 본인이 아니면
				//본인이 조회하지 않은경우 && 댓글작성하지 않은 경우
				bDao.increaseViewCount(bid);
			
			board = bDao.getBoard(bid);
			String jsonFiles = board.getFiles();
			if (!(jsonFiles == null || jsonFiles.equals(""))) {
				List<String> fileList = ju.jsonToList(board.getFiles());
				request.setAttribute("fileList", fileList);
			}
			request.setAttribute("board", board);
			List<Reply> replyList = rDao.getReplyList(bid);
			request.setAttribute("replyList", replyList);
			
			rd = request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp");
			rd.forward(request, response);
			break;
		case "write":
			if (request.getMethod().equals("GET")) {
				rd = request.getRequestDispatcher("/WEB-INF/view/board/write.jsp");
				rd.forward(request, response);
			} else {	// 입력된 데이터 받기
				title = request.getParameter("title");
				content = request.getParameter("content");
				
				List<Part> fileParts = (List<Part>) request.getParts();
				List<String> fileList = new ArrayList<String>();
				for (Part part: fileParts) {
					String filename = part.getSubmittedFileName();
					if (filename == null)
						continue;
					
					part.write(UPLOAD_PATH + filename);
					fileList.add(filename);
				}
				// filelist를 json으로 바꿔줘야함.
				files = ju.listToJson(fileList);
				
				
				
				
				board = new Board(sessionUid, title, content, files);
				bDao.insertBoard(board);
				response.sendRedirect("/bbs/board/list?p=1&f=&q=");
				
			}
			break;
			
			
		
		} //switch
	
	}
}
