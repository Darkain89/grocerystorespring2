package org.pcedu.grocerystorespring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Grocerystorespring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Grocerystorespring2Application.class, args);
    }

}
