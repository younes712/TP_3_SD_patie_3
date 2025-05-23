package com.younes.hospital2.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class SecurityController {
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
