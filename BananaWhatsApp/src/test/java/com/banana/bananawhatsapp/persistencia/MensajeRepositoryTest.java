package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.modelos.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class MensajeRepositoryTest {
    @Autowired
    IMensajeRepository repo;

    @Autowired
    IUsuarioRepository repous;

    @Test
    void dadoUnMensajeValido_cuandoCrear_entoncesMensajeValido() throws Exception {

        Usuario remi = repous.getById(5);
        Usuario dest = repous.getById(6);

        Mensaje mens = new Mensaje(null, remi, dest, "Hola qué tal", LocalDate.now());
        repo.crear(mens);
        assertThat(mens, notNullValue());
        assertThat(mens.getId(), greaterThan(0));
        assertThat(mens.getRemitente(), notNullValue());
        assertThat(mens.getDestinatario(), notNullValue());
    }


    @Test
    void dadoUnMensajeNOValido_cuandoCrear_entoncesExcepcion() {

        Mensaje mens = new Mensaje(null, null, null, "Hola qué tal", LocalDate.now());
        assertThrows(Exception.class, () -> {
            repo.crear(mens);
        });
    }

    @Test
    void dadoUnUsuarioValido_cuandoObtener_entoncesListaMensajes() {
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoObtener_entoncesExcepcion() {
    }

    @Test
    void dadoUnUsuarioValido_cuandoBorrarTodos_entoncesOK() {
    }

    @Test
    void dadoUnUsuarioNOValido_cuandoBorrarTodos_entoncesExcepcion() {
    }

}