package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <!DOCTYPE html>\r\n");
      out.write("        <html>\r\n");
      out.write("\r\n");
      out.write("        <head>\r\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("            <title>QBE</title>\r\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/bootstrap.css\">\r\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/bootstrap-responsive.css\">\r\n");
      out.write("            <script src=\"./js/code.jquery.com_jquery-3.1.1.min.js\" ></script>\r\n");
      out.write("            <script src=\"./js/bootstrap.js\" ></script>\r\n");
      out.write("            \r\n");
      out.write("        </head>\r\n");
      out.write("\r\n");
      out.write("        <body>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <center>\r\n");
      out.write("                    <h1>\r\n");
      out.write("                        Query By Example\r\n");
      out.write("                        <i class=\"icon-edit\"></i>\r\n");
      out.write("                    </h1>\r\n");
      out.write("                </center>  \r\n");
      out.write("                <br><br>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"span5 offset4\">\r\n");
      out.write("                        <div class=\"alert alert-info\">\r\n");
      out.write("                            <center><h3>Conéctate a <b>Mysql</b> </h3></center>                            \r\n");
      out.write("                        </div> \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"span5 offset4\">\r\n");
      out.write("                        <form class=\"form-horizontal\" method=\"POST\" action=\"login_servelet\">\r\n");
      out.write("                            <div class=\"control-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"user\">Usuario:</label>\r\n");
      out.write("                                <div class=\"controls\">\r\n");
      out.write("                                    <input type=\"text\" placeholder=\"Usuario\" id=\"user\" name=\"user\" autocomplete=\"off\" required>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"control-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"pass\">Password:</label>  \r\n");
      out.write("                                <div class=\"controls\">\r\n");
      out.write("                                    <input type=\"password\" placeholder=\"Password\" name=\"pass\" id=\"pass\" autocomplete=\"off\" required>\r\n");
      out.write("                                </div>                                \r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"control-group\">\r\n");
      out.write("                                <div class=\"controls\">\r\n");
      out.write("                                  <button class=\"btn btn-primary\" type=\"submit\">\r\n");
      out.write("                                    Entrar &nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                    <i class=\"icon-arrow-right icon-white\"></i>\r\n");
      out.write("                                </button>  \r\n");
      out.write("                                </div>    \r\n");
      out.write("                            </div>                            \r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>            \r\n");
      out.write("        </body>\r\n");
      out.write("\r\n");
      out.write("        </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
