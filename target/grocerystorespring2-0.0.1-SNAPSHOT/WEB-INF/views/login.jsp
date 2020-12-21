<%-- 
    Document   : login
    Created on : Dec 14, 2020, 11:45:44 AM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login - ${projectName}</h1>
        <p id="method">It came with method: ${method}</p>
        <h3 id="message">${message}</h3>
        <form method="POST" action="${action}">
            <input name="${username}" />
            <input name="${password}" type="password" />
            <button type="submit">Login</button>
        </form>
            <!--<div id="msg"><%--<c:if test="${msg} != null">${msg}</c:if>--%></div>-->
            <div id="msg">
                <% 
                    String msg;
                    if(session.getAttribute("msq") != null) {
                        msg = (String)session.getAttribute("msq");
                        out.print(msg);
                    } 
                %>
            </div>
        <div id="msg2"><%= request.getParameter("msg") %></div>
    </body>
</html>

