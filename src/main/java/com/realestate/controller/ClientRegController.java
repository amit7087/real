package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.service.ClientRegService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientReg")
public class ClientRegController {
    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    //http://localhost:8080/api/clientReg/create
    @PostMapping("/create")
    public ResponseEntity<String>createClientReg(@RequestBody ClientRegDto clientRegDto){
        clientRegService.saveUser(clientRegDto);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
