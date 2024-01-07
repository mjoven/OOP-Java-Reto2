package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.*;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicioImpl implements IServicioUsuarios {
    @Autowired
    IUsuarioRepository usuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        try {
            usuario.valido();
            usuarioRepo.crear(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error crear usuario (servicio): " + e.getMessage());
        }
        return usuario;
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        return null;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        return null;
    }

    @Override
    public Usuario getById(int id) throws UsuarioException {
        return null;
    }

    @Override
    public Usuario getUsuario(int id) throws UsuarioException {
        return null;
    }

    //@Override
    //public Usuario getById(int id) throws UsuarioException {
    //    return null;
    // }

    @Override
    public Usuario getUsuario(Usuario usuario) throws UsuarioException {

        try {
            usuario.getById(usuario.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error recuperar usuario (servicio): " + e.getMessage());
        }
        return usuario;
    }

    //@Override
    //public Usuario getById(Usuario usuario) throws UsuarioException {
    //    return null;
    //}
    /*@Override
    public Usuario getById(Usuario usuario) throws UsuarioException {
        try {
            usuarioRepo.getById(usuario.getId());

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioException("Error recuperar usuario (servicio): " + e.getMessage());
        }
        return usuario;
    }*/


}

