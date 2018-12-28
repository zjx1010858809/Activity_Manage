package com.situ.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@Order(2)
@WebFilter(filterName = "login", urlPatterns = "/*")*/
public class loginFilter implements Filter {

	public void init(FilterConfig filterconfig) throws ServletException {

	}

	String matcherall = "picshow";
	String matcher = "/allseach,/test,/logins,/situ/login.html,/situ/image/code,/situ/assets";
	String matcher1 = ".js,.css,.jpg,.gif,.png,.bmp,.wav,.ico,.woff2,.woff,.ttf";

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletrequest;
		HttpServletResponse resp = (HttpServletResponse) servletresponse;
		String name = req.getRequestURI();
		
		String hz = "";
		if (name.lastIndexOf('.') >= 0) {
			hz = name.substring(name.lastIndexOf('.'), name.length());
		}
		if (name.indexOf(matcherall) >= 0) {
			filterchain.doFilter(servletrequest, servletresponse);
			return;
		}
		if (matcher.indexOf(name) >= 0 || (matcher1.indexOf(hz) >= 0 && hz.length() > 0)) {
			filterchain.doFilter(servletrequest, servletresponse);
		} else {
			if (req.getSession().getAttribute("registers") != null) {
				filterchain.doFilter(servletrequest, servletresponse);
			} else {
				String p = req.getContextPath();
				resp.sendRedirect(p + "/login.html");
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
