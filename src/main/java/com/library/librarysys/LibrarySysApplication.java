package com.library.librarysys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LibrarySysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySysApplication.class, args);
    }

    @RestController
    public static class ReceiveDataController {
        @PostMapping("/receiveData")
        public String receiveData(@RequestBody String name) {   //receive data które jest w JavaScript
            System.out.println("Odebrano imię: " + name);

            return "Imię odebrane na serwerze: " + name;
        }
    }

}