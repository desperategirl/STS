package com.biz.gallery.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/*
 * request 가로채기를 실시하도록 함
 * 그리 하면 코드가 너무 길어지니 Spring에 있는 클래스를 하나 상속받을 것
 */
@Slf4j
public class AuthorIntercepter extends HandlerInterceptorAdapter {

	/*
	 * Dispatcher에서 Controller로 가는 도중 가로채기를 수행할 method
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String urlPath = request.getRequestURL().toString();
		String uriPath = request.getRequestURI().toString();
		
		String msg = String.format("URL : %s, \nURI : %s", urlPath, uriPath);
		
		// login 정보를 확인
		// 1 res 로부터 session ID를 추출
		HttpSession httpSession = request.getSession();
		
		// MEMBER Session을 확인하기 위해서 Attribute를 추출해서
		// Object 객체(SessionObj)에 담기
		Object sessionObj = httpSession.getAttribute("MEMBER");
		
		// Object 객체가 null 확인
		// null이면 Member Session 객체가 없다
		// 없으면 login이 되어있지 않다.
		
		
		if(sessionObj == null) {
			
			// 로그인 화면(form)으로 redirect를 수행하여
			// login을 하도록 유도 
			response.sendRedirect(
					request.getContextPath() + "/member/login");
			
			// 현재 로그인이 안 되어 있으므로 dispatcher에게 
			// 더 이상 다른 일을 수행하지 말라
			return false;
		}
		
		log.debug("나는 인터셉터입니다.");
		log.debug(msg);
		
		// return true;
		// controller에게 전달하라
		return super.preHandle(request, response, handler);
	}
	
	
	
}
