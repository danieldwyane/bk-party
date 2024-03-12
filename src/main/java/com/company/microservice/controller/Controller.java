package com.company.microservice.controller;

import com.company.microservice.dto.RequestDto;
import com.company.microservice.model.Regalos;
import com.company.microservice.service.RegalosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RegalosService regalosService;

    @GetMapping("/")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello from Railway + Spring!");
    }

    @GetMapping("/findAll")
    public List<Regalos> findAll() {
        return regalosService.findAll();
    }

    @GetMapping("/findAvailable")
    public List<Regalos> findAvailable() {
        return regalosService.findAvailable();
    }

    @PostMapping()
    public String save(@RequestBody RequestDto requestDto) {
        regalosService.save(requestDto);
        return "Guardado";
    }
}
