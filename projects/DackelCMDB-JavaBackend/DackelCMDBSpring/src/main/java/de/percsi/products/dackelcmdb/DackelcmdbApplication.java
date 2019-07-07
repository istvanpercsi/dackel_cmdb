package de.percsi.products.dackelcmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.percsi.products.dackelcmdb.api.json.controler")
public class DackelcmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DackelcmdbApplication.class, args);
    }

}
