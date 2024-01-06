package com.library.librarysys.controller;

import com.library.librarysys.users.LoggedUser;
import com.library.librarysys.users.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogInController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        LoggedUser loggedUser = new Reader();
        loggedUser.logIn(email, password);
        return ResponseEntity.ok("Success");
    }
}