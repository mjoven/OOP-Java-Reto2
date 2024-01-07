package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.exceptions.MensajeException;
import org.junit.jupiter.api.Test;
import com.banana.bananawhatsapp.modelos.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLOutput;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class ServicioMensajeriaTest {
    @Autowired
    IServicioMensajeria servicioMensajeria;

    @Autowired
    IServicioUsuarios servicioUsuarios;

    @Test
    void dadoRemitenteYDestinatarioYTextoValido_cuandoEnviarMensaje_entoncesMensajeValido() {

        Usuario uRemitente = new Usuario();
        uRemitente.setId(1);
        Usuario uDestinatario = new Usuario();
        uDestinatario.setId(2);

        Mensaje mens = new Mensaje(null, uRemitente, uDestinatario, "Hola qué hay", LocalDate.now());
        servicioMensajeria.crearMensaje(mens);
        assertThat(mens, notNullValue());
        assertThat(mens.getId(), greaterThan(0));
        assertThat(mens.getRemitente(), notNullValue());
        assertThat(mens.getDestinatario(), notNullValue());

    }


    @Test
    void dadoRemitenteYDestinatarioYTextoNOValido_cuandoEnviarMensaje_entoncesExcepcion() {
        Usuario uRemitente = new Usuario();
        uRemitente.setId(1);
        Usuario uDestinatario = new Usuario();
        uDestinatario.setId(2);

        Mensaje mens = new Mensaje(null, uRemitente, uDestinatario, "", LocalDate.now());
        assertThrows(MensajeException.class, () -> {
        servicioMensajeria.crearMensaje(mens);
        });
    }

    @Test
    void dadoRemitenteYDestinatarioValido_cuandoMostrarChatConUsuario_entoncesListaMensajes() {
    }

    @Test
    void dadoRemitenteYDestinatarioNOValido_cuandoMostrarChatConUsuario_entoncesExcepcion() {
    }

    @Test
    void dadoRemitenteYDestinatarioValido_cuandoBorrarChatConUsuario_entoncesOK() {
    }

    @Test
    void dadoRemitenteYDestinatarioNOValido_cuandoBorrarChatConUsuario_entoncesExcepcion() {
    }
}