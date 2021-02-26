
package com.istloja.controlador;

import com.istloja.conexionbd.Conexion;
import com.istloja.modelo.Inventario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Inventariobd {
     public boolean registrarInventario(Inventario inventario) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        //INSERT INTO `ejercicio`.`persona` (`idpersona`, `cedula`, `nombres`, `apellidos`, `direccion`, `correo`, `telefono`) VALUES ('1', '1104268899', 'John', 'Solano', 'Loja', 'jpsolanoc@gmail.com', '072587392');
        String sql = "INSERT INTO `bdejercicio1`.`inventario` (`id_inventario`, `codigo_pro`, `descripcion`, `precios_compra`, `precios_venta`, `can_productos`,) VALUES('" + String.valueOf(inventario.getId_inventario()) + "', '" + inventario.getCodigo_pro() + "', '" + inventario.getDescripcion() + "', '" + inventario.getPrecios_compra() + "', '" + inventario.getPrecios_venta() + "', '" + inventario.getCan_productos() + "');";
        try {
            //Es una instancia de la conexion previamente creada.
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }
     public boolean eliminar(Inventario inventario) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`inventario` WHERE (`id_inventario` = '" + String.valueOf(inventario.getId_inventario()) + "');";
        try {
            connect = new Conexion().conectarBaseDatos();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
       public List<Inventario> obtenerInventario() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.inventario;";
        List<Inventario> inventario = new ArrayList<Inventario>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario c = new Inventario();
                c.setId_inventario(rs.getInt(1));
                c.setCodigo_pro(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecios_compra(rs.getString(4));
                c.setPrecios_venta(rs.getString(5));
                c.setCan_productos(rs.getString(6));
                listaInventario.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaInventario;
    }
    
}
