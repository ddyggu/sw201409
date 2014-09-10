package co.kr.samwoospace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;	

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import co.kr.samwoospace.bean.LoginCheck;
import co.kr.samwoospace.bean.Member;

public class LoginCheckInterceptor implements HandlerInterceptor {
	
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    Member member = (Member)request.getSession().getAttribute("member");
	    if (member == null) {
	      LoginCheck check = new LoginCheck();
	      check.setMessage("관리자 로그인이 필요한 서비스입니다.");
	      check.setCheck(false);
	      request.setAttribute("check", check);
	      request.getRequestDispatcher("/admin/index").forward(request, response);
	    }
	    return true;
	  }

	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	    throws Exception {
	  
	  }

	  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	    throws Exception {
	  
	  }
}

