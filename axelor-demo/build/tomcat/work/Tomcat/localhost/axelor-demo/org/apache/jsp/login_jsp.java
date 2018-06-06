/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.24
 * Generated at: 2018-06-06 15:07:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import com.axelor.i18n.I18n;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/axelor.tld", Long.valueOf(1528297599000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.axelor.i18n.I18n");
    _jspx_imports_classes.add("java.util.function.Function");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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



Function<String, String> T = new Function<String, String>() {
  public String apply(String t) {
    try {
      return I18n.get(t);
    } catch (Exception e) {
      return t; 
    }
  }
};

String loginTitle = T.apply("Please sign in");
String loginRemember = T.apply("Remember me");
String loginSubmit = T.apply("Log in");

String loginUserName = T.apply("Username");
String loginPassword = T.apply("Password");

String warningBrowser = T.apply("Update your browser!");
String warningAdblock = T.apply("Adblocker detected!");
String warningAdblock2 = T.apply("Please disable the adblocker as it may slow down the application.");

int year = Calendar.getInstance().get(Calendar.YEAR);
String copyright = String.format("&copy; 2005 - %s Axelor. All Rights Reserved.", year);

String loginHeader = "/login-header.jsp";
if (pageContext.getServletContext().getResource(loginHeader) == null) {
  loginHeader = null;
}

@SuppressWarnings("all")
Map<String, String> tenants = (Map) session.getAttribute("tenantMap");
String tenantId = (String) session.getAttribute("tenantId");


      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta name=\"google\" content=\"notranslate\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"ico/favicon.ico\">\n");
      out.write("    ");
      if (_jspx_meth_x_005fstyle_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_x_005fscript_005f0(_jspx_page_context))
        return;
      out.write("</head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    ");
 if (loginHeader != null) { 
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  loginHeader , out, false);
 } 
      out.write("<div class=\"container-fluid\">\n");
      out.write("      <div class=\"panel login-panel\">\n");
      out.write("        <div class=\"panel-header panel-default\">\n");
      out.write("          <img src=\"img/axelor.png\" width=\"192px\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"panel-body\">\n");
      out.write("          <form id=\"login-form\" action=\"\" method=\"POST\">\n");
      out.write("            <div class=\"form-fields\">\n");
      out.write("              <div class=\"input-prepend\">\n");
      out.write("                <span class=\"add-on\"><i class=\"fa fa-envelope\"></i></span>\n");
      out.write("                <input type=\"text\" id=\"usernameId\" name=\"username\" placeholder=\"");
      out.print( loginUserName );
      out.write("\" autofocus=\"autofocus\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"input-prepend\">\n");
      out.write("                <span class=\"add-on\"><i class=\"fa fa-lock\"></i></span>\n");
      out.write("                <input type=\"password\" id=\"passwordId\" name=\"password\" placeholder=\"");
      out.print( loginPassword );
      out.write("\">\n");
      out.write("              </div>\n");
      out.write("              ");
 if (tenants != null && tenants.size() > 1) { 
      out.write("<div class=\"input-prepend\">\n");
      out.write("                <span class=\"add-on\"><i class=\"fa fa-database\"></i></span>\n");
      out.write("                <select name=\"tenantId\">\n");
      out.write("                ");
 for (String key : tenants.keySet()) { 
      out.write("<option value=\"");
      out.print( key );
      out.write('"');
      out.write(' ');
      out.print( (key.equals(tenantId) ? "selected" : "") );
      out.write('>');
      out.print( tenants.get(key) );
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("</select>\n");
      out.write("              </div>\n");
      out.write("              ");
 } 
      out.write("<label class=\"ibox\">\n");
      out.write("                <input type=\"checkbox\" value=\"rememberMe\" name=\"rememberMe\">\n");
      out.write("                <span class=\"box\"></span>\n");
      out.write("                <span class=\"title\">");
      out.print( loginRemember );
      out.write("</span>\n");
      out.write("              </label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-footer\">\n");
      out.write("              <button class=\"btn btn-primary\" type=\"submit\">");
      out.print( loginSubmit );
      out.write("</button>\n");
      out.write("            </div>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"br-warning\" class=\"alert alert-block alert-error hidden\">\n");
      out.write("\t  \t<h4>");
      out.print( warningBrowser );
      out.write("</h4>\n");
      out.write("\t  \t<ul>\n");
      out.write("\t  \t\t<li>Chrome</li>\n");
      out.write("\t  \t\t<li>Firefox</li>\n");
      out.write("\t  \t\t<li>Safari</li>\n");
      out.write("\t  \t\t<li>IE >= 11</li>\n");
      out.write("\t  \t</ul>\n");
      out.write("\t  </div>\n");
      out.write("\t  <div id=\"ad-warning\" class=\"alert hidden\">\n");
      out.write("\t  \t<h4>");
      out.print( warningAdblock );
      out.write("</h4>\n");
      out.write("\t  \t");
      out.print( warningAdblock2 );
      out.write("</div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer class=\"container-fluid\">\n");
      out.write("      <p class=\"credit small\">");
      out.print( copyright );
      out.write("</p>\n");
      out.write("    </footer>\n");
      out.write("    \n");
      out.write("    <div id=\"adblock\"></div>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(function () {\n");
      out.write("\t    if (axelor.browser.msie && !axelor.browser.rv) {\n");
      out.write("\t    \t$('#br-warning').removeClass('hidden');\n");
      out.write("\t    }\n");
      out.write("\t    if ($('#adblock') === undefined || $('#adblock').is(':hidden')) {\n");
      out.write("\t    \t$('#ad-warning').removeClass('hidden');\n");
      out.write("\t    }\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_x_005fstyle_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  x:style
    com.axelor.web.tags.StyleTag _jspx_th_x_005fstyle_005f0 = new com.axelor.web.tags.StyleTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_x_005fstyle_005f0);
    try {
      _jspx_th_x_005fstyle_005f0.setJspContext(_jspx_page_context);
      // /login.jsp(72,4) name = src type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_x_005fstyle_005f0.setSrc("css/application.login.css");
      _jspx_th_x_005fstyle_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_x_005fstyle_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_x_005fscript_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  x:script
    com.axelor.web.tags.ScriptTag _jspx_th_x_005fscript_005f0 = new com.axelor.web.tags.ScriptTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_x_005fscript_005f0);
    try {
      _jspx_th_x_005fscript_005f0.setJspContext(_jspx_page_context);
      // /login.jsp(73,4) name = src type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_x_005fscript_005f0.setSrc("js/application.login.js");
      _jspx_th_x_005fscript_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_x_005fscript_005f0);
    }
    return false;
  }
}
