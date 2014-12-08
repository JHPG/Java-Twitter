<%@page import="dao.MensagensDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="img/fav.png">
        <!--<link rel="icon" href="http://www.mackenzie.com.br/fileadmin/CONFIG/TEMPLATES/UP_MACKENZIE/IMAGENS/comuns/favicon.ico" type="image/x-icon; charset=binary" />-->

        <title>MackTwitter</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/offcanvas.css" rel="stylesheet"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet"/>

        <link href="css/style.css" rel="stylesheet"/>
        
        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                <![endif]-->
    </head>

    <body>
        <%
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
        %>
        <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand navTitu" href="Home.jsp" style="color:#fff;">MackTwitter</a>
                </div>
                <div class="collapse navbar-collapse">
                    <!-- Aqui vai ficar o código para depois de logado -->
                    <ul class="nav navbar-nav">
                        <li><a href="Mensagens.jsp">Mensagens</a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div><!-- /.container -->
        </div><!-- /.navbar -->

        <div class="container" style="margin-top:80px">		<!-- Corpo-->

            <div class="row row-offcanvas row-offcanvas-right">
                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs">
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron">
                        <h3 class='saudacaoHome' style="font-family:Calibri">
                            MackTwitter
                        </h3> 
                        <br/><br/><br/>
                        <button class="btn btn-large btn-primary" onclick="window.location='Mensagens.jsp'"type="submit" style="margin-left:45px"> Ver mensagens </button>
                    </div>
                </div>
                
                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <div class="list-group-item" style="height:300px;">
                            <form class="navbar-form navbar-right" role="form" method="POST" action="/MackTwitter/FrontController">
                                <h3 class='navTitu' style="font-size:35px;">Login</h3>
                                <input type="text" name="usuario" placeholder="Usuario" class="form-control" value=<%=login%>>
                                <input type="password" name="senha" placeholder="Senha" class="form-control" style="margin-top:5px;">
                                <label style="color:#000" class="login"><input type="checkbox" name="lembrar"> Lembrar </label><br/>
                                <!--<button type="submit" class="btn btn-success login">Entrar</button> Botão verde-->
                                <input type="hidden" name="acao" value="usuLogin"/>
                                <%--<bean id="acao" class="">
                                    <property name="acao" value="usuLogin"/>
                                </bean>--%>
                                <button class="btn btn-large btn-primary" type="submit">Entrar</button>
                            </form>
                        </div>
                        <p class="list-group-item">Usuários logados: <%=nUsers%></p>
                        <p class="list-group-item">Mensagens no sistema: <%=nMsg%></p>
                    </div>
                </div><!--/span-->
            </div><!--/row-->

            <hr/>

            <footer>
                <p>&copy; Fabio Figueira, Jorge Henrique e Raphael Marinho</p>
            </footer>

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
