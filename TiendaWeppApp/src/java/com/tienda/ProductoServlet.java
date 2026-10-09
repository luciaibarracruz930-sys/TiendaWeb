/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tienda;

import com.tienda.database.Database;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucia
 */
public class ProductoServlet extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         try
        {
            Database db = new Database();
            java.sql.Connection conn = db.getConnection();
            PreparedStatement pstat = conn.prepareStatement("SELECT * FROM productos");
        
            ResultSet rs = pstat.executeQuery();
        
            List<producto> productos;
            productos= new ArrayList<>();
             
        
            while(rs.next()){
                productos.add(new producto(
                        rs.getInt("Id"),                 
                        rs.getString("Name"),                 
                        rs.getDouble("Precio") ,                
                        rs.getInt("Stock")               
                     ));           
            }
                     
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("Producto.jsp").forward(request, response);   
        }
        catch (SQLException ex)
        {
            System.getLogger(ProductoServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
 }

   
      
 

   
   
    
