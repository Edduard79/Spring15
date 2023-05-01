package com.example.Ex15;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legacy")
@ResponseStatus(HttpStatus.GONE)
public class LegacyController {

    @GetMapping
    public String getLegacyMessage(@RequestHeader("User-Agent") String userAgent) {
        if(userAgent.contains("Mozilla/5.0") || userAgent.contains("Opera") || userAgent.contains("Edg")) {
            return "This is just old code";
        } else {
            return " ";
        }
    }
}
