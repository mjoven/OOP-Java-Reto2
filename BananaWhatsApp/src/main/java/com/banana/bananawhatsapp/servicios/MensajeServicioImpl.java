package com.banana.bananawhatsapp.servicios;
import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.*;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServicioImpl implements IServicioMensajeria {
    @Autowired
    IMensajeRepository mensajeRepo;


    @Override
    public Mensaje crearMensaje(Mensaje mensaje) throws MensajeException {
        try {
            mensaje.valido();
            mensajeRepo.crear(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MensajeException("Error crear mensaje (servicio): " + e.getMessage());
        }
        return mensaje;
    }

    @Override
    public Mensaje enviarMensaje(Usuario remitente, Usuario destinatario, String texto) throws UsuarioException, MensajeException {
       return null;

    }

    @Override
    public List<Mensaje> mostrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        return null;
    }

    @Override
    public boolean borrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        return false;
    }

    @Override
    public Usuario getById(int id) throws UsuarioException {
        return null;
    }


}
