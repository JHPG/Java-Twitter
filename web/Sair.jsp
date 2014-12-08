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
                        <li><a  href="Home.jsp">Home</a></li>
                        <li><a href="Perfil.jsp">Perfil</a></li>
                        <li><a href="Mensagens.jsp">Mensagens</a></li>
                        <li><a class="active2" href="/MackTwitter/FrontController?acao=usuSair">Sair</a></li>
                    </ul>
                    <div class="navbar-form" role="form">
                        <p class="login" style="text-align:right">
                            <button href="Login.jsp" onclick="window.location='Login.jsp'" class="btn btn-success">Entrar</button>
                        </p>
                    </div>

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

                        <span class="titu">Muito obrigado pelo acesso!</span>
                        <br/>
                        <button class="btn btn-large btn-primary" onclick="window.location='Login.jsp'"type="submit" style="margin-left:45px;margin-top:100px;"> Logar novamente </button>
                    </div>

                </div><!--/span-->

            </div><!--/row-->

            <hr/>

            <footer>
                <p>&copy; Fabio Figueira, Jorge Henrique e Raphael Marinho</p>
            </footer>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
