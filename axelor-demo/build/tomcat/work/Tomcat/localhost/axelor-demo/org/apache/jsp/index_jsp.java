/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.24
 * Generated at: 2018-06-06 14:58:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.axelor.app.AppSettings;
import com.axelor.web.internal.AppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/axelor.tld", Long.valueOf(1528297108000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Locale");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.axelor.app.AppSettings");
    _jspx_imports_classes.add("java.util.stream.Collectors");
    _jspx_imports_classes.add("com.axelor.web.internal.AppInfo");
    _jspx_imports_classes.add("java.util.ArrayList");
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


AppSettings settings = AppSettings.get();
AppInfo info = new AppInfo();

String appName = settings.get("application.name", "My App");
String appDesc = settings.get("application.description", null);
String appHome = settings.get("application.home", "");
String appLogo = info.getLogo();
String appStyle = info.getStyle();
String appAuthor = settings.get("application.author", "");
String appTheme = info.getTheme();
String appMenu = settings.get("application.menu", "both");

String appTitle =  appName;

if (appDesc != null) {
  appTitle = appName + " :: " + appDesc;
}

String extraHead = "/index-head.jsp";
String extraFoot = "/index-foot.jsp";
String extraButtons = "/index-nav-buttons.jsp";

if (pageContext.getServletContext().getResource(extraHead) == null) {
	extraHead = null;
}
if (pageContext.getServletContext().getResource(extraFoot) == null) {
	extraFoot = null;
}
if (pageContext.getServletContext().getResource(extraButtons) == null) {
	extraButtons = null;
}

@SuppressWarnings("all")
Map<String, String> tenantMap = (Map) session.getAttribute("tenantMap");
String tenantId = (String) session.getAttribute("tenantId");


      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"");
      out.print( info.getPageLang() );
      out.write("\" ng-app=\"axelor.app\" ng-controller=\"AppCtrl\" ng-cloak>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>");
      out.print( appTitle );
      out.write("</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta name=\"google\" content=\"notranslate\">\n");
      out.write("    <meta name=\"description\" content=\"");
      out.print( appDesc );
      out.write("\">\n");
      out.write("    <meta name=\"author\" content=\"");
      out.print( appAuthor );
      out.write("\">\n");
      out.write("\n");
      out.write("    <!-- Le styles -->\n");
      out.write("    ");
      if (_jspx_meth_x_005fstyle_005f0(_jspx_page_context))
        return;
 if (appTheme != null) { 
      out.write("<link href=\"css/");
      out.print( appTheme );
      out.write("/theme.css\" rel=\"stylesheet\">\n");
      out.write("    ");
 } 
 if (appStyle != null) { 
      out.write("<style>\n");
      out.write("    ");
      out.print( appStyle );
      out.write("</style>\n");
      out.write("    ");
 } 
      out.write("<!-- Le fav and touch icons -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"ico/favicon.ico\">\n");
      out.write("    ");
 if (extraHead != null) { 
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  extraHead , out, false);
 } 
      out.write("</head>\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("    <header class=\"header\">\n");
      out.write("      <div class=\"navbar navbar-fixed-top\">\n");
      out.write("        <div class=\"navbar-inner\">\n");
      out.write("          <div class=\"container-fluid\">\n");
      out.write("            <ul class=\"nav hidden\" id=\"offcanvas-toggle\">\n");
      out.write("              <li>\n");
      out.write("                <a href=\"\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("            </ul>\n");
      out.write("            ");
 if (appLogo == null || "".equals(appLogo)) { 
      out.write("<a class=\"brand\" href=\"");
      out.print( appHome );
      out.write('"');
      out.write('>');
      out.print( appName );
      out.write("</a>\n");
      out.write("            ");
 } else { 
      out.write("<a class=\"brand-logo\" href=\"");
      out.print( appHome );
      out.write("\">\n");
      out.write("              <img src=\"");
      out.print( appLogo );
      out.write("\">\n");
      out.write("            </a>\n");
      out.write("            ");
 } 
 if (!"left".equals(appMenu)) { 
      out.write("<ul class=\"nav hidden-phone\" data-nav-menu-bar></ul>\n");
      out.write("            ");
 } 
      out.write("<ul class=\"nav nav-shortcuts pull-right\">\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("              <li>\n");
      out.write("                <a href=\"#/\" class=\"nav-link-home\"><i class=\"fa fa-home\"></i></a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("              <li class=\"dropdown\">\n");
      out.write("                <a href=\"javascript:\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                  <i class=\"fa fa-star\"></i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"dropdown-menu\" nav-menu-fav></ul>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("              <li>\n");
      out.write("                <a href=\"\" class=\"nav-link-mail\"\n");
      out.write("                  ng-click=\"showMailBox()\"><i class=\"fa fa-envelope\"></i><sup\n");
      out.write("                    ng-show=\"unreadCount=$unreadMailCount()\">{{unreadCount}}</sup></a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("              <li nav-menu-tasks></li>\n");
      out.write("              <li class=\"divider-vertical\"></li>\n");
      out.write("              <li class=\"dropdown\">\n");
      out.write("                <a href=\"javascript:\" class=\"dropdown-toggle nav-link-user\" data-toggle=\"dropdown\">\n");
      out.write("                  <img ng-src=\"{{ $user.image }}\" width=\"20px\"> <b class=\"caret\"></b>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                  <li>\n");
      out.write("                    <a href=\"#/preferences\">\n");
      out.write("                      <span class=\"nav-link-user-name\">{{ $user.name }}</span>\n");
      out.write("                      <span class=\"nav-link-user-sub\" x-translate>Preferences</span>\n");
      out.write("                    </a>\n");
      out.write("                  </li>\n");
      out.write("                  ");
 if (tenantMap != null && tenantMap.size() > 1) { 
      out.write("<li class=\"divider\"></li>\n");
      out.write("\t              <li>\n");
      out.write("\t                <a href=\"\"><strong>");
      out.print( tenantMap.get(tenantId) );
      out.write("</strong></a>\n");
      out.write("\t              </li>\n");
      out.write("                  <li class=\"dropdown-submenu\">\n");
      out.write("                  \t<a tabIndex=\"-1\" href=\"\" x-translate>More...</a>\n");
      out.write("                  \t<ul class=\"dropdown-menu\">\n");
      out.write("                  \t");
 for (String key : tenantMap.keySet()) { 
 if (!key.equals(tenantId)) { 
      out.write("<li><a href=\"login.jsp?tenant=");
      out.print( key );
      out.write('"');
      out.write('>');
      out.print( tenantMap.get(key) );
      out.write("</a></li>\n");
      out.write("                  \t");
 } 
 } 
      out.write("</ul>\n");
      out.write("                  </li>\n");
      out.write("                  ");
 } 
      out.write("<li class=\"divider\"></li>\n");
      out.write("                  <li><a href=\"#/about\"><span x-translate>About</span></a></li>\n");
      out.write("                  <li><a href=\"logout\"><span x-translate>Log out</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("            ");
 if (extraButtons != null) { 
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  extraButtons , out, false);
 } 
      out.write("</div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div ng-include x-src=\"'partials/login-window.html'\"></div>\n");
      out.write("    <div ng-include x-src=\"'partials/error-window.html'\"></div>\n");
      out.write("\n");
      out.write("    <section role=\"main\" id=\"container\" ng-switch x-on=\"routePath[0]\">\n");
      out.write("      ");
 if ("top".equals(appMenu)) { 
      out.write("<div class=\"fill-parent\" ng-show=\"routePath[0] == 'main'\" ng-include x-src=\"'partials/main-nomenu.html'\"></div>\n");
      out.write("      ");
 } else { 
      out.write("<div class=\"fill-parent\" ng-show=\"routePath[0] == 'main'\" ng-include x-src=\"'partials/main.html'\"></div>\n");
      out.write("      ");
 } 
      out.write("<div ng-switch-when=\"about\"><div ng-include x-src=\"'partials/about.html'\"></div></div>\n");
      out.write("      <div ng-switch-when=\"system\"><div ng-include x-src=\"'partials/system.html'\"></div></div>\n");
      out.write("      <div ng-switch-when=\"welcome\"><div ng-include x-src=\"'partials/welcome.html'\"></div></div>\n");
      out.write("      <div ng-switch-when=\"preferences\"><div ng-include x-src=\"'partials/preferences.html'\"></div></div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <!-- JavaScript at the bottom for fast page loading -->\n");
      out.write("    <script src=\"js/messages.js\"></script>\n");
      out.write("    ");
      if (_jspx_meth_x_005fscript_005f0(_jspx_page_context))
        return;
 if (extraFoot != null) { 
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response,  extraFoot , out, false);
 } 
      out.write("</body>\n");
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
      // /index.jsp(79,4) name = src type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_x_005fstyle_005f0.setSrc("css/application.css");
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
      // /index.jsp(191,4) name = src type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_x_005fscript_005f0.setSrc("js/application.js");
      _jspx_th_x_005fscript_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_x_005fscript_005f0);
    }
    return false;
  }
}
