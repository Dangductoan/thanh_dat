package com.toandd.project.thanhdat.source.boundary;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
@CrossOrigin
public class TestController {
    @GetMapping
    public String getString() {
        return "hello every one";
    }
}
