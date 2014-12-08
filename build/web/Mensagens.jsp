<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.*" %>
<%@page import="entidade.*" %>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta charset="utf-8">-->
        <meta charset="windows-1252">
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

        <script src="js/script.js"></script>
        <link href="css/style.css" rel="stylesheet"/>

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <%
            String nUsers = "0";
            int nMsg = 0;
            String order = "";

            ServletContext context = request.getSession().getServletContext();
            String user = (String) request.getSession().getAttribute("login");
            try{
                    order = (String) request.getParameter("order");
            }catch(Exception e){
                    order = "";
            }

            MensagensDAO m = new MensagensDAO();

            List<Mensagem> msgLista = m.getMensagens(order); //Armazena as msg do banco na lista

            try{
                    nUsers = context.getAttribute("nUsers").toString();
            }
            catch(Exception e){ nUsers="0"; }

            try {
                    nMsg = msgLista.size(); //Pega qtde de mensagens. 
            } catch (Exception e) { nMsg = 0; }
        %>        
    </head>

    <body onload="onLoad()">

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
                    <%  try {
                        if (user != "null") {       //Verifica se há alguém logado para não exibir o Olá;%>
                                <li><a  href="Home.jsp">Home</a></li>
                                <li><a href="Perfil.jsp">Perfil</a></li>
                                <li><a class="active2" href="Mensagens.jsp">Mensagens</a></li>
                                <li><a href="/MackTwitter/FrontController?acao=usuSair">Sair</a></li>
                                <% 
                        }
                    } catch (Exception e) { }%>

                    </ul>
                    <div class="navbar-form" role="form">
                        <p class="login" style="text-align:right">
                            <% if(user != null) {             //Verifica se há alguém logado para não exibir o Olá; %>

                                <span class="saudacao"> Olá <%=user%> </span>

                            <% } else { %>
                                <div class="navbar-form" role="form">
                                    <p class="login" style="text-align:right">
                                            <button href="Login.jsp" onclick="window.location = 'Login.jsp'" class="btn btn-success">Entrar</button>
                                    </p>
                                </div>
                            <%}%>
                        </p>
                    </div>

                </div><!-- /.nav-collapse -->
            </div><!-- /.container -->
        </div><!-- /.navbar -->

        <div class="container" style="margin-top:80px">		<!-- Corpo-->

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9 conteudo">
                    <p class="pull-right visible-xs">
                            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron" id="mensagens">
                        <h2 class="titu">Mensagens: </h2>

                        <%//---------------------  Aqui exibe as mensagens -------------------------------------
                                //Usar um timer para recarregar só esse conteúdo, não a página inteira
                                //setTimeout(function(), 10000);

                        if (! msgLista.isEmpty()) //Se não for vazia
                        {
                            for (Mensagem msg : msgLista) { %>

                                <div class="msgContainer">
                                    <div class="infUsersMsg">
                                        <div style="font-weight:bold">
                                                <%=msg.getLogin()%>: 
                                        </div>
                                    </div>
                                    <div class="mensagem">
                                        <input type="hidden" id="msgV" value="<%=msg.getMensagem()%>"/> <!--Para não dar erro de quebra de linha na função javascript-->
                                        <script> // Exibir os emoticons
                                            //Retorna texto com imagens
                                            //document.write( insereEmoticons(document.getElementById("msgV").value) );
                                        </script>
                                        <%=msg.insereEmoticons()%>
                                        <br/>
                                        <span style="font:italic 12px 'Lucida Console'">
                                            Enviado em: <%=msg.getHora()%>
                                        </span>
                                    </div>
                                </div>
                                <div class="clear"></div>
                            <% }  
                        } else {
                            %> Não há mensagens para exibir. <%                        
                        } %>
                    </div>
                    <% if (user != null) {%>
                    <form name="escrever" method="GET" action="/MackTwitter/FrontController" >
                        <textarea name="txtMensagem" id="txtMensagem" class="form-control" placeholder="Escreva sua mensagem." onkeypress="contarChar(this.value);"
                            onkeydown="contarChar(this.value);" onkeyup="contarChar(this.value);"></textarea>
                        <br/>

                        <input type="hidden" name="acao" value="escreverMensagem"/>
                        <input type="submit" value="Enviar" style="margin-right:10px"/>
                        Caracteres restantes: <span id="contagem"></span><!--Contagem de caracteres restantes-->
                        <br/>
                        <div id="emoticons">
                            <img src="emoticons/deOlho.gif" alt="" onclick="getEmoticon('deOlho')"/>     <!--aqui-->
                            <img src="emoticons/sorriso.gif" alt="" onclick="getEmoticon('sorriso')"/>
                            <img src="emoticons/triste.gif" alt="" onclick="getEmoticon('triste')"/>
                            <img src="emoticons/img2.gif" alt="" onclick="getEmoticon('img2')"/>
                        </div>
                    </form>
                    <% }%>
                </div>

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <p class="list-group-item">Usuários logados: <%=nUsers%></p>
                        <p class="list-group-item"><%="Nº de mensagens: " + nMsg%></p>
                        <span class="list-group-item">
                            <form method="POST" action="Mensagens.jsp">       <!-- Ordenar -->

                                <select name="order" class="form-control" onchange="this.form.submit();">
                                    <option value="ID" selected>Ordenar mensagens</option>
                                    <option value="ID">Por ID</option>
                                    <option value="hora">Por horário</option>
                                    <option value="login">Por usuario</option>
                                    <option value="influ">Por influência</option>
                                </select>
                            </form>
                        </span>
                    </div>
                </div>

            </div><!--/span-->
            
        <hr/>

        <footer>
                <p>&copy; Fabio Figueira, Jorge Henrique e Raphael Marinho</p>
        </footer>
        </div><!--/row-->
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script> setTimeout(function(){ $("#mensagens").load(); }, 500); </script>

</body>
</html>
