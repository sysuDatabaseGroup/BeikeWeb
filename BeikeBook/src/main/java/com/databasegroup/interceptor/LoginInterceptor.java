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
		
		// �����¼ҳ�棬�ж�session���Ƿ���key���еĻ��ض�����ҳ����������¼����
		  if(uri.contains("login")) {
		      if(request.getSession().getAttribute("user") != null) {
		         response.sendRedirect(request.getContextPath());//Ĭ�ϸ�·��Ϊ��ҳ
		      } else {
		         return true;//������½����
		      }
		  }
		  
		// ��������ж�session�Ƿ���key���еĻ������û�����
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}
		
		// ���ֻʣ�µ�¼����
		response.sendRedirect(request.getContextPath() + "/login");
		return true;
	}

	//����������ɣ�����ͼ��Ⱦ��������ã����ʱ�������Щ��Դ������������־��¼��
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	//�ڿ������������ú󣬽�����ͼǰ���ã����ǿ��Զ���ͼ��ģ������һ����Ⱦ���޸�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
