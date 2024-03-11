package com.codeinternals.microservices.postservice.config;

import brave.sampler.Sampler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 1. PropertySources is required in case we want to specify
 *    multiple configuration files. There's an alternative way
 *    specified in application.properties file.
 * 2. EntityScan is required in case the entities are present
 *    in different package other than the package from where
 *    spring boot app is running
 * 3. EnableEncryptableProperties is required if using jasypt-spring-boot
 *    dependency instead of jasypt-spring-boot-starter
 * 4. ComponentScan is required in case beans need to be loaded from
 *    another project outside the spring boot application project
 * 5. EnableJpaRepositories - explicit annotation is required if jpa
 *    repositories are outside the spring boot application package
 * 6. EnableJpaAuditing is to Audit the tables
 */

@Configuration
//@PropertySources({
//        @PropertySource(value = "classpath:db.properties"),
//        @PropertySource(value = "classpath:application.properties")
//})
@EntityScan(basePackages = {"com.codeinternals.microservices.datamodel"})
//@EnableEncryptableProperties
@ComponentScan(basePackages = {"com.codeinternals.microservices.datamodel"})
@EnableJpaRepositories(value = "com.codeinternals.microservices.datamodel.repository")
@EnableJpaAuditing
public class AppConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
