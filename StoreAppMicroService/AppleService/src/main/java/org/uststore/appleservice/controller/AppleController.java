package org.uststore.appleservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppleController {

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    public String home(){
        return "Hello World";
    }
}
