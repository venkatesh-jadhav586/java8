package com.cafe.registration;

import org.springframework.web.bind.annotation.*;


@RestController

public class RegistrationController {
    @GetMapping(value = "/login")
    public String login(@RequestParam String m) {
System.out.println("i am ok");
        return m;


    }
}
