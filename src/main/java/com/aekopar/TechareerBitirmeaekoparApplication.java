package com.aekopar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//exclude:dahil etmemek

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

//Audit
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class TechCareerBitirmeaekoparApplication {


    public static void main(String[] args) {
        SpringApplication.run(TechCareerBitirmeaekoparApplication.class, args);

        //DevTools
        System.setProperty("spring.devtools.restart.enabled","false");

        // AWT: JOptionPanel set ayarı
        System.setProperty("java.awt.headless", "false");
    }

}
