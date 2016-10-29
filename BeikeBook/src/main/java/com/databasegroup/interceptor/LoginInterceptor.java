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
		// 保存登录前的页面
		request.getSession().setAttribute("lastPage",
				request.getServletPath());
		
		// 判断是否是登录页面
		  if(uri.contains("login")) {
		      if(request.getSession().getAttribute("user") != null) {
		         response.sendRedirect(request.getContextPath());// 已登录就跳到根目录
		      } else {
		         return true;// 未登录就继续
		      }
		  }
		  
		// 已登录就继续原操作
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}
		// 其他情况就是登录页面
		response.sendRedirect(request.getContextPath() + "/login");
		return true;
	}

	// 整个请求结束之后的操作，渲染视图之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("afterCompletion");
	}

	// 控制器方法调用后，解析视图前调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle");
	}
	
	
}
