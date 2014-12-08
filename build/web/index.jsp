<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            if (request.getSession().getAttribute("login") == null) {
                response.sendRedirect("Login.jsp");
            } else {
                response.sendRedirect("Home.jsp");
            }
        
        %>
    </body>
</html>
