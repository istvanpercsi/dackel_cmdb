package de.percsi.product.entitymanager.configuration;

import com.fasterxml.jackson.databind.Module;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForVavrSerialiseDeserialize {

    @Bean
    Module initVavrJacksonModule() {
        return new VavrModule();
    }

}
