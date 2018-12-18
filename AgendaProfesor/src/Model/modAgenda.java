/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Capsules.CapAgenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leopt_000
 */
public class modAgenda extends mdlConexion {

    mdlConexion conec = new mdlConexion();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean borrarAmigo(CapAgenda age) {
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();

            String sql = "DELETE FROM amigos WHERE DOCUMENTO=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setLong(1, age.getDOCUEMTO());
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean RegistrarAmigo(CapAgenda age) {
        try {

            Connection con = getConexion();

            String sql = "insert into amigos (DOCUMENTO,TELEFONO,NOMBRE,CORREO,DIRECCION) VALUES(?,?,?,?,?)";

            try {

                ps = con.prepareStatement(sql);
                ps.setLong(2, age.getTELEFONO());
                ps.setString(3, age.getNOMBRE());
                ps.setString(4, age.getCORREO());
                ps.setString(5, age.getDIRECCION());
                ps.setLong(1, age.getDOCUEMTO());

                ps.execute();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Modificar(CapAgenda age) {

        try {

            Connection con = getConexion();

            String sql = "UPDATE amigos SET NOMBRE=?, CORREO=?, DIRECCION=?, TELEFONO=?  WHERE DOCUMENTO=? ";

            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, age.getNOMBRE());
                ps.setString(2, age.getCORREO());

                ps.setString(3, age.getDIRECCION());
                ps.setLong(5, age.getDOCUEMTO());
                ps.setLong(4, age.getTELEFONO());

                ps.execute();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public DefaultTableModel MostrarAmigos(String busqui) throws ClassNotFoundException {
        Connection con = getConexion();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("DOCUMENTO");
        tabla.addColumn("TELEFONO");
        tabla.addColumn("NOMBRE");
        tabla.addColumn("CORREO");
        tabla.addColumn("DIRECCION");
       
        String sql = "";
        if (busqui.equals("")) {
            sql = "SELECT * FROM amigos";
        } else {
            sql = "SELECT * FROM amigos WHERE DOCUMENTO='" + busqui + "'";

        }

        String datos[] = new String[5];
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                tabla.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(modAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tabla;

    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

}
