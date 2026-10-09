<%-- 
    Document   : producto-edit
    Created on : Oct 8, 2026, 7:05:35 PM
    Author     : lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> web app </title>
    </head>
    <body>
        <form method="POST" action="PersonServlet">
            Name:<input type="text" name="nombre" /> <br>
            Price:<input type ="text" name="precio"/><br>
            Stock:<input type="number" name="stocke" /><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
