package cn.ziroom.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.common.manager.SessionManager;
import cn.common.resource.ResourceManager;
import cn.ziroom.system.domain.User;
import cn.ziroom.system.service.UserService;

public class ZiruFilter implements Filter {

	private List<String> notIntercept = new ArrayList<String>();

	private WebApplicationContext wac;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			// 初始化资源文件
			ResourceManager.init();
			String not = ResourceManager.getString("filter.not.intercept");
			notIntercept = Arrays.asList(not.split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}
		wac = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getRequestURI().lastIndexOf("/") + 1, httpServletRequest.getRequestURI().lastIndexOf(".do"));
		if (notIntercept.contains(url)) {
			filterChain.doFilter(httpServletRequest, servletResponse);
		} else {
			User user = (User) httpServletRequest.getSession().getAttribute(SessionManager.USER_KEY);
			if (user != null) {
				filterChain.doFilter(httpServletRequest, servletResponse);
			} else {
				UserService us = (UserService) getBean("userService");
				String staffId = httpServletRequest.getParameter("staffid");
				user = us.searchUserByStaffId(staffId);
				if (user != null) {
					httpServletRequest.getSession().setAttribute(SessionManager.USER_KEY, user);
					httpServletRequest.getSession().setAttribute(SessionManager.FUNCTION_KEY, us.getFunction(user.getStaffRole()));
					filterChain.doFilter(httpServletRequest, servletResponse);
				} else {
					RequestDispatcher rd = httpServletRequest.getRequestDispatcher("index.jsp");
					rd.forward(servletRequest, servletResponse);
				}
			}
		}
	}

	/**
	 * 获得Bean
	 * 
	 * @param beanName
	 * @return
	 */
	private Object getBean(String beanName) {
		return wac.getBean(beanName);
	}

	@Override
	public void destroy() {

	}
}
