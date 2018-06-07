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

      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("        <!DOCTYPE html>\n");
      out.write("        <html>\n");
      out.write("\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>QBE</title>\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/bootstrap.css\">\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/bootstrap-responsive.css\">\n");
      out.write("            <script src=\"./js/code.jquery.com_jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"./js/bootstrap.js\" ></script>\n");
      out.write("            \n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <center>\n");
      out.write("                    <h1>\n");
      out.write("                        Query By Example\n");
      out.write("                        <i class=\"icon-edit\"></i>\n");
      out.write("                    </h1>\n");
      out.write("                </center>  \n");
      out.write("                <br><br>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"span5 offset4\">\n");
      out.write("                        <div class=\"alert alert-info\">\n");
      out.write("                            <center><h3>Conéctate a <b>Mysql</b> </h3></center>                            \n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br><br>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"span5 offset4\">\n");
      out.write("                        <form class=\"form-horizontal\" method=\"POST\" action=\"login_servelet\">\n");
      out.write("                            <div class=\"control-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"user\">Usuario:</label>\n");
      out.write("                                <div class=\"controls\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"Usuario\" id=\"user\" name=\"user\" autocomplete=\"off\" required>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"control-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"pass\">Password:</label>  \n");
      out.write("                                <div class=\"controls\">\n");
      out.write("                                    <input type=\"password\" placeholder=\"Password\" name=\"pass\" id=\"pass\" autocomplete=\"off\" required>\n");
      out.write("                                </div>                                \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"control-group\">\n");
      out.write("                                <div class=\"controls\">\n");
      out.write("                                  <button class=\"btn btn-primary\" type=\"submit\">\n");
      out.write("                                    Entrar &nbsp;&nbsp;&nbsp;\n");
      out.write("                                    <i class=\"icon-arrow-right icon-white\"></i>\n");
      out.write("                                </button>  \n");
      out.write("                                </div>    \n");
      out.write("                            </div>                            \n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>            \n");
      out.write("        </body>\n");
      out.write("\n");
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
