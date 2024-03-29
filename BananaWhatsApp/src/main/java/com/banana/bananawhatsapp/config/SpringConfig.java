package com.banana.bananawhatsapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@Import({RepoConfig.class, ControllerConfig.class})
@ComponentScan({"com.banana.bananawhatsapp.servicios"})
public class SpringConfig {
}
