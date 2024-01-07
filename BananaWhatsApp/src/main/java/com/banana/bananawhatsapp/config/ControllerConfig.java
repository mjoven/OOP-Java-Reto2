package com.banana.bananawhatsapp.config;

import com.banana.bananawhatsapp.controladores.ControladorUsuarios;
import com.banana.bananawhatsapp.controladores.ControladorMensajes;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import com.banana.bananawhatsapp.servicios.IServicioMensajeria;
import com.banana.bananawhatsapp.servicios.IServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Autowired
    IServicioUsuarios userSvr;

    @Bean
    ControladorUsuarios crearUsuarioController() {
        ControladorUsuarios controller = new ControladorUsuarios();
        controller.setServicioUsuarios(userSvr);
        return controller;

    }

    @Autowired
    IServicioMensajeria mensSvr;

    @Bean
    ControladorMensajes crearMensajeController() {
        ControladorMensajes controller = new ControladorMensajes();
        controller.setServicioMensajeria(mensSvr);
        return controller;

    }
}
