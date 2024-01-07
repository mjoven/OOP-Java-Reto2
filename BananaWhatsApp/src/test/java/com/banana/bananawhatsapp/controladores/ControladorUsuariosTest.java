package com.banana.bananawhatsapp.controladores;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
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
class ControladorUsuariosTest {
    @Autowired
    ControladorUsuarios controladorUsuarios;

    @Test
    void dadoUsuarioValido_cuandoAlta_entoncesUsuarioValido() {
        Usuario usgen = new Usuario(null, "Pepe", "pepe@mail.com", LocalDate.now(), true);
        controladorUsuarios.alta(usgen);
        assertThat(usgen, notNullValue());
        assertThat(usgen.getId(), greaterThan(0));
    }

    @Test
    void dadoUsuarioNOValido_cuandoAlta_entoncesExcepcion() {
        Usuario usgen = new Usuario(null, "Pepe", "pepe", LocalDate.now(), true);
        assertThrows(UsuarioException.class, () -> {
            controladorUsuarios.alta(usgen);
        });
    }

    @Test
    void dadoUsuarioValido_cuandoActualizar_entoncesUsuarioValido() {
    }

    @Test
    void dadoUsuarioNOValido_cuandoActualizar_entoncesExcepcion() {
    }

    @Test
    void dadoUsuarioValido_cuandoBaja_entoncesUsuarioValido() {
    }

    @Test
    void dadoUsuarioNOValido_cuandoBaja_entoncesExcepcion() {
    }
}