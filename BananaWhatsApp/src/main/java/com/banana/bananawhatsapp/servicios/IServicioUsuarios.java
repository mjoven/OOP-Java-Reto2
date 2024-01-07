package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.*;
import java.util.Set;

public interface IServicioUsuarios {
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException;

    public boolean borrarUsuario(Usuario usuario) throws UsuarioException;

    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException;

    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException;


    public Usuario getById(int id) throws UsuarioException;

    public Usuario getUsuario(int id) throws UsuarioException;

    public Usuario getUsuario(Usuario usuario) throws UsuarioException;


}
