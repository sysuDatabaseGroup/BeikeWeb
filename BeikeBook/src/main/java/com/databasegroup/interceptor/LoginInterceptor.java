package com.databasegroup.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println("TAG:" + uri);
		System.out.println("TAG:" + request.getSession().getAttribute("username"));
		System.out.println("TAG:" + request.getContextPath());
		if (request.getSession().getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		System.out.println("TAG: endOfPreHandle()");
		return true;
	}

	//整个请求完成，即视图渲染结束后调用，这个时候可以做些资源清理工作，或日志记录等
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	//在控制器方法调用后，解析视图前调用，我们可以对视图和模型做进一步渲染或修改
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
