package com.databasegroup.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		
		// 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
		  if(uri.contains("login")) {
		      if(request.getSession().getAttribute("adminUserName") != null) {
		         response.sendRedirect(request.getContextPath() + "/backend/index");//默认根路径为首页
		      } else {
		         return true;//继续登陆请求
		      }
		  }
		  
		// 其他情况判断session是否有key，有的话继续用户操作
		if (request.getSession().getAttribute("adminUserName") != null) {
			return true;
		}
		
		// 最后只剩下登录界面
		response.sendRedirect(request.getContextPath() + "/backend/login");
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
