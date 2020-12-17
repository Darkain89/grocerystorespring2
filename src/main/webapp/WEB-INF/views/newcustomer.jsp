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
    </head>
    <body>
        <h1>Customer - ${projectName}</h1>
        <f:form method="POST" action="new" modelAttribute="customer">
            First Name:<f:input path="firstName" /><br>
            Last Name:<f:input path="lastName" /><br>
            Email:<f:input path="email" /><br>
            Tel:<f:input path="tel" /><br>
            <f:button name="btnNewCustomer">Insert New Customer</f:button>
        </f:form>
    </body>
</html>
