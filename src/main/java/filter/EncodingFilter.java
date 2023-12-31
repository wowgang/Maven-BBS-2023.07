package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BbsFilter
 */
// @WebFilter("/*") 나한테 들어오는 모든것을 encoding하겠다.  
//controller에서는 개별적으로 주는게 맞음
@WebFilter({"/aside/*", "/board/*", "/file/*", "/reply/*", "/user/*"})
public class EncodingFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		request.setCharacterEncoding("utf-8");	// 인코딩
		
		chain.doFilter(request, response);
	}


}
