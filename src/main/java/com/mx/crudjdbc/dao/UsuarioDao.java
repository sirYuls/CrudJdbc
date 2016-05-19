package com.mx.crudjdbc.dao;

import com.mx.crudjdbc.vo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author bl4ck0is1s
 */
public interface UsuarioDao extends CrudDao<Usuario> {
    
    public Usuario saveUsuario(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);
    
    public Usuario getUsuarioById(int id);
    
    public ResultSet getAll();
    
    public boolean deleteUsuario(int idUsuario);
}
