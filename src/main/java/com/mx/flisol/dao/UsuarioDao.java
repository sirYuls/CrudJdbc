package com.mx.flisol.dao;

import com.mx.flisol.vo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author bl4ck0is1s
 */
public interface UsuarioDao extends FlisolDao<Usuario> {
    
    public Usuario saveUsuario(Usuario usuario);
    
    public Usuario updateUsuario(Usuario usuario);
    
    public Usuario getUsuarioById(int id);
    
    public ResultSet getAll();
    
    public boolean deleteUsuario(int idUsuario);
}
