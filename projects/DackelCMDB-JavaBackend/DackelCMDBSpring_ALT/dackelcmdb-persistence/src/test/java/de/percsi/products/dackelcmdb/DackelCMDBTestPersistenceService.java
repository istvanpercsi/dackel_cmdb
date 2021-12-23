package de.percsi.products.dackelcmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@SpringBootApplication
public class DackelCMDBTestPersistenceService {
  public static void main(String[] args) {
    SpringApplication.run(DackelCMDBTestPersistenceService.class, args);
  }
}
