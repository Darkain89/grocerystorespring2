<%-- 
    Document   : newcustomer
    Created on : Dec 17, 2020, 11:03:54 AM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Customer Page</title>
          <link rel="stylesheet" href="/css/style.css" />
          <script src="/js/script.js"></script>
    </head>
    <body>
        <h1 class="error">Customer - ${projectName}</h1>
        <!--<button onclick="myAlert()">MyButton</button>-->
        <f:form method="POST" action="new" modelAttribute="customer">
            First Name:<f:input path="firstName" /><f:errors path="firstName" cssClass="error"></f:errors><br>
            Last Name:<f:input path="lastName" /><br>
            Email:<f:input path="email" type="email"/> <f:errors path="email" cssClass="error"></f:errors><br>
            Tel:<f:input path="tel" /><br>
            <f:button name="btnNewCustomer">Insert New Customer</f:button>
            <div class="error">${error}</div>
        </f:form>
    </body>
</html>
