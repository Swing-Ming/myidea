/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-07-13 10:00:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/notice/../include/mainHeader.jsp", Long.valueOf(1468299514640L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("This is a starter template page. Use this page to start your new project from\r\n");
      out.write("scratch. This page gets rid of all links and provides the needed markup only.\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>新增公告</title>\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/AdminLTE.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/skins/skin-blue.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/simditor/styles/simditor.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Main Header -->\r\n");
      out.write("<header class=\"main-header\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Logo -->\r\n");
      out.write("    <a href=\"index2.html\" class=\"logo\">\r\n");
      out.write("        <!-- mini logo for sidebar mini 50x50 pixels -->\r\n");
      out.write("        <span class=\"logo-mini\">项目</span>\r\n");
      out.write("        <!-- logo for regular state and mobile devices -->\r\n");
      out.write("        <span class=\"logo-lg\">CRM</span>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Navbar -->\r\n");
      out.write("    <nav class=\"navbar navbar-static-top\" role=\"navigation\">\r\n");
      out.write("        <!-- Sidebar toggle button-->\r\n");
      out.write("        <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <!-- Navbar Right Menu -->\r\n");
      out.write("        <div class=\"navbar-custom-menu\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <!-- Messages: style can be found in dropdown.less-->\r\n");
      out.write("                <li class=\"dropdown messages-menu\">\r\n");
      out.write("                    <!-- Menu toggle button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fa fa-envelope-o\"></i>\r\n");
      out.write("                        <span class=\"label label-success\">4</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li class=\"header\">You have 4 messages</li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <!-- inner menu: contains the messages -->\r\n");
      out.write("                            <ul class=\"menu\">\r\n");
      out.write("                                <li><!-- start message -->\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <div class=\"pull-left\">\r\n");
      out.write("                                            <!-- User Image -->\r\n");
      out.write("                                            <img src=\"/static/dist/img/user2-160x160.jpg\" class=\"img-circle\"\r\n");
      out.write("                                                 alt=\"User Image\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <!-- Message title and timestamp -->\r\n");
      out.write("                                        <h4>\r\n");
      out.write("                                            Support Team\r\n");
      out.write("                                            <small><i class=\"fa fa-clock-o\"></i> 5 mins</small>\r\n");
      out.write("                                        </h4>\r\n");
      out.write("                                        <!-- The message -->\r\n");
      out.write("                                        <p>Why not buy a new awesome theme?</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- end message -->\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <!-- /.menu -->\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"footer\"><a href=\"#\">See All Messages</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.messages-menu -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Notifications Menu -->\r\n");
      out.write("                <li class=\"dropdown notifications-menu\">\r\n");
      out.write("                    <!-- Menu toggle button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fa fa-bell-o\"></i>\r\n");
      out.write("                        <span class=\"label label-warning\">10</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li class=\"header\">You have 10 notifications</li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <!-- Inner Menu: contains the notifications -->\r\n");
      out.write("                            <ul class=\"menu\">\r\n");
      out.write("                                <li><!-- start notification -->\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <i class=\"fa fa-users text-aqua\"></i> 5 new members joined today\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- end notification -->\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"footer\"><a href=\"#\">View all</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- Tasks Menu -->\r\n");
      out.write("                <li class=\"dropdown tasks-menu\">\r\n");
      out.write("                    <!-- Menu Toggle Button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <i class=\"fa fa-flag-o\"></i>\r\n");
      out.write("                        <span class=\"label label-danger\">9</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li class=\"header\">You have 9 tasks</li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <!-- Inner menu: contains the tasks -->\r\n");
      out.write("                            <ul class=\"menu\">\r\n");
      out.write("                                <li><!-- Task item -->\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <!-- Task title and progress text -->\r\n");
      out.write("                                        <h3>\r\n");
      out.write("                                            Design some buttons\r\n");
      out.write("                                            <small class=\"pull-right\">20%</small>\r\n");
      out.write("                                        </h3>\r\n");
      out.write("                                        <!-- The progress bar -->\r\n");
      out.write("                                        <div class=\"progress xs\">\r\n");
      out.write("                                            <!-- Change the css width attribute to simulate progress -->\r\n");
      out.write("                                            <div class=\"progress-bar progress-bar-aqua\" style=\"width: 20%\"\r\n");
      out.write("                                                 role=\"progressbar\" aria-valuenow=\"20\" aria-valuemin=\"0\"\r\n");
      out.write("                                                 aria-valuemax=\"100\">\r\n");
      out.write("                                                <span class=\"sr-only\">20% Complete</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- end task item -->\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"footer\">\r\n");
      out.write("                            <a href=\"#\">View all tasks</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- User Account Menu -->\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <!-- Menu Toggle Button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <span class=\"hidden-xs\">");
      if (_jspx_meth_shir_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                      <li><a href=\"/user/password\"/>修改密码</li>\r\n");
      out.write("                        <li><a href=\"/user/password\"/>登录日志</li>\r\n");
      out.write("                        <li class=\"divider\"></li>\r\n");
      out.write("                        <li><a href=\"/logout\"/>安全退出</li>\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/leftSide.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("menu", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("notice", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("            <div class=\"box box-primary\">\r\n");
      out.write("                <div class=\"box-header with-border\">\r\n");
      out.write("                    <h3 class=\"box-title\">新增公告</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <form method=\"post\" id=\"newForm\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>标题</label>\r\n");
      out.write("                            <input type=\"text\" name=\"title\" class=\"form-control\" id=\"title\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label>公告内容</label>\r\n");
      out.write("                            <textarea name=\"content\" id=\"context\" cols=\"10\" class=\"form-control\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"box-footer\">\r\n");
      out.write("                        <button id=\"save-btn\" class=\"btn btn-primary pull-right\">发表</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery 2.2.3 -->\r\n");
      out.write("    <script src=\"/static/plugins/jQuery/jquery-2.2.3.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("    <script src=\"/static/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- AdminLTE App -->\r\n");
      out.write("    <script src=\"/static/dist/js/app.min.js\"></script>\r\n");
      out.write("    <script src=\"/static/plugins/simditor/scripts/module.min.js\"></script>\r\n");
      out.write("    <script src=\"/static/plugins/simditor/scripts/hotkeys.min.js\"></script>\r\n");
      out.write("    <script src=\"/static/plugins/simditor/scripts/uploader.min.js\"></script>\r\n");
      out.write("    <script src=\"/static/plugins/simditor/scripts/simditor.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function(){\r\n");
      out.write("            var edit = new Simditor({\r\n");
      out.write("                textarea:$(\"#context\"),\r\n");
      out.write("                placeholder: '请输入公告内容',\r\n");
      out.write("                upload:{\r\n");
      out.write("                    url:\"/notice/img/upload\",\r\n");
      out.write("                    fileKey:\"file\"\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            $(\"#save-btn\").click(function(){\r\n");
      out.write("                if(!$(\"#title\").val()){\r\n");
      out.write("                    $(\"#title\").focus();\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                if(!$(\"#context\").val()){\r\n");
      out.write("                    $(\"#context\").focus();\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                $(\"#newForm\").submit();\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shir_005fprincipal_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shir:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shir_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shir_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shir_005fprincipal_005f0.setParent(null);
    // /WEB-INF/views/notice/../include/mainHeader.jsp(125,48) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shir_005fprincipal_005f0.setProperty("realname");
    int _jspx_eval_shir_005fprincipal_005f0 = _jspx_th_shir_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shir_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shir_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshir_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shir_005fprincipal_005f0);
    return false;
  }
}
