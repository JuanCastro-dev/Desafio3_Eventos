package io.github.juandev.mseventmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MsEventManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEventManagerApplication.class, args);
    }

}
