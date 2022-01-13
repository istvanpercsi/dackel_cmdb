package de.percsi.products.dackelcmdb.service.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "de.percsi.products.dackelcmdb.service")
@EnableJpaRepositories(basePackages = "de.percsi.products.dackelcmdb.persistence")
@EntityScan(basePackages = "de.percsi.products.dackelcmdb.persistence")
public class ServiceConfiguration {

}
