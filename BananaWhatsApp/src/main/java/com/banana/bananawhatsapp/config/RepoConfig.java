package com.banana.bananawhatsapp.config;

import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import com.banana.bananawhatsapp.persistencia.UsuarioJDBCRepo;
import com.banana.bananawhatsapp.persistencia.MensajeJDBCRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RepoConfig {
    @Value("${db_url}")
    String connUrl;

    @Bean
    IUsuarioRepository crearUsuarioRepo() {
        UsuarioJDBCRepo repo = new UsuarioJDBCRepo();
        repo.setDb_url(connUrl);
        return repo;
    }

    @Bean
    IMensajeRepository crearMensajeRepo() {
        MensajeJDBCRepo repo = new MensajeJDBCRepo();
        repo.setDb_url(connUrl);
        return repo;
    }
}
