package com.mx.flisol.dao.impl;

import com.mx.flisol.config.ConnectionDataBase;
import com.mx.flisol.dao.UsuarioDao;
import com.mx.flisol.vo.Usuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class UsuarioDaoImpl implements UsuarioDao {

    private static final Logger logger = Logger.getLogger(UsuarioDaoImpl.class);

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        Connection reg = ConnectionDataBase.getConexion();
                    
        String sql = "INSERT INTO usuario (nombre, apellido_paterno, apellido_materno, edad, username, "
                + "password) VALUES "
                + "(?,?,?,?,?"
                + ",?)";
        try {

            PreparedStatement pst = reg.prepareStatement(sql);

            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidoPaterno());
            pst.setString(3, usuario.getApellidoMaterno());
            pst.setInt(4, usuario.getEdad());
            pst.setString(5, usuario.getUsername());
            pst.setString(6, usuario.getPassword());

            int n = pst.executeUpdate();
            if (n > 0) {
                logger.debug("usuario registrado: " + usuario.toString());
                JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente");
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Connection connection = ConnectionDataBase.getConexion();
        String sql = "UPDATE usuario SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, edad = ?,"
                + " username = ?, password = ? WHERE id_usuario = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidoPaterno());
            pst.setString(3, usuario.getApellidoMaterno());
            pst.setInt(4, usuario.getEdad());
            pst.setString(5, usuario.getUsername());
            pst.setString(6, usuario.getPassword());
            pst.setInt(7, usuario.getIdUsuario());

            int n = pst.executeUpdate();
            if (n == 1) {
                logger.debug("usuario registrado: " + usuario.toString());
                JOptionPane.showMessageDialog(null, "El Usuario se Actualizo Exitosamente");
                return usuario;
            }

        } catch (HeadlessException ex) {
            logger.error(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario getUsuarioById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll() {
         Connection conexion = ConnectionDataBase.getConexion();
        try {
            String sql = "SELECT * FROM usuario";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            return rs;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteUsuario(int idUsuario) {
        Connection connection = ConnectionDataBase.getConexion();
        String sql = "DELETE from usuario where id_usuario = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);

            int n = pst.executeUpdate();
            if (n == 1) {
                logger.debug("usuario eliminado: " + idUsuario);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                return true;
            }

        } catch (HeadlessException ex) {
            logger.error(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - " + ex);
            ex.printStackTrace();
        }
        return false;
    }

}
