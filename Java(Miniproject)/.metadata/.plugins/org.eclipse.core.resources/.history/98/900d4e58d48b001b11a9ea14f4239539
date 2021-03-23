package kr.co.softcampus.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	
	@Autowired
	private TopMenuService topMenuService;
	
	public TopMenuInterceptor(TopMenuService topMenuService){
		this.topMenuService = topMenuService;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);

		return true; 
	}

}
