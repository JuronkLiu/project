package com.lzr.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		
		ModelAndView maView = new ModelAndView();
		
		if (e instanceof MessageException) {
			MessageException me = (MessageException) e;
			maView .addObject("error", me.getMsg());
		}else{
			maView.addObject("error", "未知异常");
		}
		maView.setViewName("error/error");
		
		return maView;
	}

}
