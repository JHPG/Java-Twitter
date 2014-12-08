package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.MensagensDAO;
import java.util.List;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/fav.png\">\r\n");
      out.write("        <!--<link rel=\"icon\" href=\"http://www.mackenzie.com.br/fileadmin/CONFIG/TEMPLATES/UP_MACKENZIE/IMAGENS/comuns/favicon.ico\" type=\"image/x-icon; charset=binary\" />-->\r\n");
      out.write("\r\n");
      out.write("        <title>MackTwitter</title>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/offcanvas.css\" rel=\"stylesheet\"/>\r\n");
      out.write("        <link href=\"css/bootstrap-theme.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\"/>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Just for debugging purposes. Don't actually copy this line! -->\r\n");
      out.write("        <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("                <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("                <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("                <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            if (request.getSession().getAttribute("login") != null){ //Se logado manda para Home
                response.sendRedirect("Home.jsp"); 
            }
            
            String login = "", nUsers="0";
            int nMsg=0;
            
            Cookie[] cookies = request.getCookies();
            ServletContext context = request.getSession().getServletContext();
            
            if(cookies != null){
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("lembrarUsuario")) {
                        login = cookies[i].getValue();
                    }
                }
            }
            try{
                nUsers = context.getAttribute("nUsers").toString();
            }catch(Exception e){
                nUsers="0";
                e.printStackTrace();
            }
                
            try{
                MensagensDAO m = new MensagensDAO();
                nMsg = m.getMensagens("").size(); //Pega qtde de mensagens. 
            }catch(Exception e){
                e.printStackTrace();
            }
        
      out.write("\r\n");
      out.write("        <div class=\"navbar navbar-fixed-top navbar-inverse\" role=\"navigation\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <a class=\"navbar-brand navTitu\" href=\"Home.jsp\" style=\"color:#fff;\">MackTwitter</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\">\r\n");
      out.write("                    <!-- Aqui vai ficar o código para depois de logado -->\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("                        <li><a href=\"Mensagens.jsp\">Mensagens</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div><!-- /.nav-collapse -->\r\n");
      out.write("            </div><!-- /.container -->\r\n");
      out.write("        </div><!-- /.navbar -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\" style=\"margin-top:80px\">\t\t<!-- Corpo-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row row-offcanvas row-offcanvas-right\">\r\n");
      out.write("                <div class=\"col-xs-12 col-sm-9\">\r\n");
      out.write("                    <p class=\"pull-right visible-xs\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary btn-xs\" data-toggle=\"offcanvas\">Toggle nav</button>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <div class=\"jumbotron\">\r\n");
      out.write("                        <h3 class='saudacaoHome' style=\"font-family:Calibri\">\r\n");
      out.write("                            MackTwitter\r\n");
      out.write("                        </h3> \r\n");
      out.write("                        <br/><br/><br/>\r\n");
      out.write("                        <button class=\"btn btn-large btn-primary\" onclick=\"window.location='Mensagens.jsp'\"type=\"submit\" style=\"margin-left:45px\"> Ver mensagens </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-xs-6 col-sm-3 sidebar-offcanvas\" id=\"sidebar\" role=\"navigation\">\r\n");
      out.write("                    <div class=\"list-group\">\r\n");
      out.write("                        <div class=\"list-group-item\" style=\"height:300px;\">\r\n");
      out.write("                            <form class=\"navbar-form navbar-right\" role=\"form\" method=\"POST\" action=\"/MackTwitter/FrontController\">\r\n");
      out.write("                                <h3 class='navTitu' style=\"font-size:35px;\">Login</h3>\r\n");
      out.write("                                <input type=\"text\" name=\"usuario\" placeholder=\"Usuario\" class=\"form-control\" value=");
      out.print(login);
      out.write(">\r\n");
      out.write("                                <input type=\"password\" name=\"senha\" placeholder=\"Senha\" class=\"form-control\" style=\"margin-top:5px;\">\r\n");
      out.write("                                <label style=\"color:#000\" class=\"login\"><input type=\"checkbox\" name=\"lembrar\"> Lembrar </label><br/>\r\n");
      out.write("                                <!--<button type=\"submit\" class=\"btn btn-success login\">Entrar</button> Botão verde-->\r\n");
      out.write("                                <input type=\"hidden\" name=\"acao\" value=\"usuLogin\"/>\r\n");
      out.write("                                ");
      out.write("\r\n");
      out.write("                                <button class=\"btn btn-large btn-primary\" type=\"submit\">Entrar</button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"list-group-item\">Usuários logados: ");
      out.print(nUsers);
      out.write("</p>\r\n");
      out.write("                        <p class=\"list-group-item\">Mensagens no sistema: ");
      out.print(nMsg);
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div><!--/span-->\r\n");
      out.write("            </div><!--/row-->\r\n");
      out.write("\r\n");
      out.write("            <hr/>\r\n");
      out.write("\r\n");
      out.write("            <footer>\r\n");
      out.write("                <p>&copy; Fabio Figueira, Jorge Henrique e Raphael Marinho</p>\r\n");
      out.write("            </footer>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
