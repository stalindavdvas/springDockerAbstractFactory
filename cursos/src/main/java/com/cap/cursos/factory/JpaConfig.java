package com.cap.cursos.factory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EnableJpaRepositories(basePackages = "com.cap.cursos.repository.postgres")
@EntityScan(basePackages = "com.cap.cursos.dto.postgres")
public class JpaConfig {
    // No es necesario agregar ningún método aquí
    // Las anotaciones se encargan de la configuración
}