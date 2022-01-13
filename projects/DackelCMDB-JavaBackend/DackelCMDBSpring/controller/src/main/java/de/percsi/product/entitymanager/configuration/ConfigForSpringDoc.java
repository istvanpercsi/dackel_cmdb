package de.percsi.product.entitymanager.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.SpringDocConfiguration;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class ConfigForSpringDoc {


    @Bean
    public OpenAPI entityManagerOpenapi() {
        return new OpenAPI()
                .info(new Info().title("Entity Manager API")
                        .description(" It is an API for Dackel CMDB. (Configruation Management DataBase) It is a lightweight Database, where you\n" +
                                "    can store entities and properties, and their connections.")
                        .version("v0.0.1")
                        .contact(new Contact().name("Istvan Percsi").url("https://github.com/istvanpercsi").email("istvan.percsi.de@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .tags(Arrays.asList(
                        new Tag().name(Tags.ENTITIES).description("Get entities, crate new entity, update entity add property to entity with value."),
                        new Tag().name(Tags.PROPERTIES).description("Get properties, create a new property, delete properties")
                        ));
    }

    public static class Tags {
        public static final String ENTITIES = "Entities";
        public static final String PROPERTIES = "Properties";
    }
}
