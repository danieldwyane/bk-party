package com.company.microservice.controller;

import com.company.microservice.dto.RequestDto;
import com.company.microservice.model.Regalos;
import com.company.microservice.service.RegalosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "https://site-production-3dda.up.railway.app/")
    @GetMapping("/findAvailable")
    public List<Regalos> findAvailable() {
        return regalosService.findAvailable();
    }

    @CrossOrigin(origins = "https://site-production-3dda.up.railway.app/")
    @PostMapping()
    public String save(@RequestBody RequestDto requestDto) {
        regalosService.save(requestDto);
        return "Guardado";
    }
}
