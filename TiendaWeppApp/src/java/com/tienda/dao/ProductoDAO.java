/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.dao;

import com.tienda.database.Database;
import com.tienda.producto;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;


public class ProductoDAO {
  public boolean guardar(producto p) {

        String sql = "INSERT INTO productos "

                   + "(nombre, precio, stock) VALUES (?, ?, ?)";

        Database db = new Database();

        try (Connection conn = db.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());

            ps.setDouble(2, p.getPrecio());

            ps.setInt(3, p.getStock());

            return ps.executeUpdate() > 0;

        } catch (SQLException | NullPointerException ex) {

            System.getLogger(ProductoDAO.class.getName()).log(

                System.Logger.Level.ERROR,

                "Error al guardar el producto",

                ex

            );

            return false;

        } finally {

            db.Close();

        }

    }

    public List<producto> listar() {

        List<producto> lista = new ArrayList<>();

        String sql = "SELECT id, nombre, precio, stock "

                   + "FROM productos ORDER BY id";

        Database db = new Database();

        try (Connection conn = db.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                producto p = new producto();

                p.setId(rs.getInt("id"));

                p.setNombre(rs.getString("nombre"));

                p.setPrecio(rs.getDouble("precio"));

                p.setStock(rs.getInt("stock"));

                lista.add(p);

            }

        } catch (SQLException | NullPointerException ex) {

            System.getLogger(ProductoDAO.class.getName()).log(

                System.Logger.Level.ERROR,

                "Error al listar productos",

                ex

            );

        } finally {

            db.Close();

        }

        return lista;

    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM productos WHERE id = ?";

        Database db = new Database();

        try (Connection conn = db.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException | NullPointerException ex) {

            System.getLogger(ProductoDAO.class.getName()).log(

                System.Logger.Level.ERROR,

                "Error al eliminar el producto",

                ex

            );

            return false;

        } finally {

            db.Close();

        }

    }  
}
