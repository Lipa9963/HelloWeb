<%-- 
    Document   : response
    Created on : Sep 4, 2016, 11:34:03 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       Your value: <%=request.getParameter("output")%>
    <jsp:useBean id="mybean" scope="session" class="org.mypackage.Expression.inputExpression" />
    <jsp:setProperty name="mybean" property="expression" />
    <h1>Hello, <jsp:getProperty name="mybean" property="expression" />!</h1>
    


</body>
</html>
