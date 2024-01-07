package com.banana.bananawhatsapp.controladores;

import static org.junit.jupiter.api.Assertions.*;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class ControladorMensajesTest {
    @Autowired
    ControladorMensajes controladorMensajes;


    @Test
    void dadoRemitenteYDestinatarioYTextoValidos_cuandoEnviarMensaje_entoncesOK() {
        Usuario uRemitente = new Usuario();
        uRemitente.setId(1);
        Usuario uDestinatario = new Usuario();
        uDestinatario.setId(2);
        Mensaje mens = new Mensaje(null, uRemitente, uDestinatario, "Hola qué tal", LocalDate.now());
        controladorMensajes.crear(mens);
        assertThat(mens, notNullValue());
        assertThat(mens.getId(), greaterThan(0));
    }

    @Test
    void dadoRemitenteYDestinatarioYTextoNOValidos_cuandoEnviarMensaje_entoncesExcepcion() {
        Usuario uRemitente = new Usuario();
        uRemitente.setId(1);
        Usuario uDestinatario = new Usuario();
        uDestinatario.setId(2);
        Mensaje mens = new Mensaje(null, uRemitente, uDestinatario, "", LocalDate.now());
        controladorMensajes.crear(mens);
        assertThat(mens, notNullValue());
        assertThat(mens.getId(), greaterThan(0));
    }

    @Test
    void dadoRemitenteYDestinatarioValidos_cuandoMostrarChat_entoncesOK() {
    }

    @Test
    void dadoRemitenteYDestinatarioNOValidos_cuandoMostrarChat_entoncesExcepcion() {
    }

    @Test
    void dadoRemitenteYDestinatarioValidos_cuandoEliminarChatConUsuario_entoncesOK() {
    }

    @Test
    void dadoRemitenteYDestinatarioNOValidos_cuandoEliminarChatConUsuario_entoncesExcepcion() {
    }
}