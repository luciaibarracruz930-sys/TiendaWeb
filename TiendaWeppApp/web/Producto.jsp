<%-- 
    Document   : Producto
    Created on : Oct 8, 2026, 6:06:56 PM
    Author     : lucia
--%>


<%@page import="com.tienda.producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Store products</title>
    </head>

    <body>
        <h1>Store products</h1>

        <%
            List<producto> productos =
                (List<producto>) request.getAttribute("productos");
        %>

        <ul>
            <%
                if (productos != null) {
                    for (producto producto : productos) {
            %>
                <li>
                    Product: <%= producto.getNombre() %>
                    Price: <%= producto.getPrecio() %>
                    Stock: <%= producto.getStock() %>
                </li>
            <%
                    }
                }
            %>
        </ul>

    </body>
</html>