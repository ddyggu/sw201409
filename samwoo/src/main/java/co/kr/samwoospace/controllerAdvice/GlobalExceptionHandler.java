package co.kr.samwoospace.controllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import co.kr.samwoospace.bean.ResponStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView resolveException(HttpServletRequest request, MultipartHttpServletRequest mRequest, HttpServletResponse response, 
										 Object handler, Exception exception) {
		
		String URI = request.getRequestURI();
		ResponStatus respon = new ResponStatus(false, "업로드 허용된 용량을 초과하였습니다.");
		ModelAndView mav = new ModelAndView(URI, "respon", respon);
		
		return null;
	}
}
