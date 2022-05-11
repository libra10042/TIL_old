/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-07 02:55:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex01_005fsession_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	//request scope에 저장된 데이터 사용
	String req_name = (String) request.getAttribute("req_name");
	String req_age = (String) request.getAttribute("req_age");
	
	//session scope에 저장된 데이터 사용
	System.out.println(">>session id : " + session.getId() 
			+ ", new : " + session.isNew());
	String name = null; 
	String age = null;
	if (session.getAttribute("attr_name") == null) {//없으면
		name = "세션에 속성 없음(attr_name)";
	} else {
		name = (String) session.getAttribute("attr_name");
	}
	if (session.getAttribute("attr_age") != null) {//있으면
		age = (String) session.getAttribute("attr_age");
	} else {
		age = "세션에 속성 없음(attr_age)";
	}
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>세션(session) 범위</title>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction sessionSet() {\r\n");
      out.write("\t\t//location.href = \"ex01_sessionSet.jsp?name=hong\";\r\n");
      out.write("\t\tlocation.href = \"ex01_sessionSet.jsp?name=hong&age=27\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction sessionRemove() {\r\n");
      out.write("\t\tlocation.href = \"ex01_sessionRemove.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction sessionInvalidate() {\r\n");
      out.write("\t\tlocation.href = \"ex01_sessionInvalidate.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>세션(session) 테스트</h1>\r\n");
      out.write("\t<input type=\"button\" value=\"세션 속성에 저장\" onclick=\"sessionSet()\">\r\n");
      out.write("\t<input type=\"button\" value=\"세션 속성 삭제\" onclick=\"sessionRemove()\">\r\n");
      out.write("\t<input type=\"button\" value=\"세션 초기화\" onclick=\"sessionInvalidate()\">\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>세션스코프(session)</h1>\r\n");
      out.write("\t<h2>세션ID : </h2>\r\n");
      out.write("\t<h2>이름(session) : ");
      out.print(name );
      out.write("</h2>\r\n");
      out.write("\t<h2>나이(session) : -");
      out.print(age );
      out.write("-</h2>\r\n");
      out.write("\t<hr><hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<h1>request 스코프(request)</h1>\r\n");
      out.write("\t<h2>이름(request) : ");
      out.print(req_name );
      out.write("</h2>\r\n");
      out.write("\t<h2>나이(request) : ");
      out.print(req_age );
      out.write("</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br><br><br><br><br><br><br><br><br><br>\r\n");
      out.write("\t<br><br><br><br><br><br><br><br><br><br><br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
