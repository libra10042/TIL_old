package kr.co.softcampus.config;


import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class SpringConfigClass implements WebApplicationInitializer{
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		
//		// Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//		
//		
//		// 요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정한다.
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//		
//		//부가 설정 ( 모든 요청에 대해 가장 먼저 받아 들이겠다.!)
//		servlet.setLoadOnStartup(1); //가장 먼저 로딩하겠다.
//		servlet.addMapping("/"); // 모든 요청을 받아 들인다.
//		
//		
//		//Bean을 정의하는 클래스를 지정한다.
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//		
//		
//		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listener);
//		
//		
//		// 파라미터 인코딩 설정. 
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher");
//		
//		
//	}
//}

// 위방법 보다는 간단하지만 정해진 대로 밖에 사용하지 못해 자율성이 떨어진다.
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	//DispatcherServlet에 매핑할 요청 주소를 선택한다.
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	
	
	//Spring MVC 프로젝트 설정을 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class} ;
	}
	
	
	//프로젝트에서 사용할 Bean을 정의하기위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class} ;
	}
	
	
	// 파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	

	
}