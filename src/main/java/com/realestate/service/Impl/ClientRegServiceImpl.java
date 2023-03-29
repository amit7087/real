package com.realestate.service.Impl;

import com.realestate.entity.ClientReg;
import com.realestate.payload.ClientRegDto;
import com.realestate.repository.ClientRegRepository;
import com.realestate.service.ClientRegService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    private PasswordEncoder passwordEncoder;

    private ClientRegRepository clientRegRepository;

    public ClientRegServiceImpl(PasswordEncoder passwordEncoder, ClientRegRepository clientRegRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientRegRepository = clientRegRepository;

    }


    @Override
    public void saveUser(ClientRegDto clientRegDto) {
        ClientReg clientReg = mapToEntity(clientRegDto);
        ClientReg saveclientReg = clientRegRepository.save(clientReg);
    }

    private ClientReg mapToEntity(ClientRegDto clientRegDto) {
        ClientReg clientReg = new ClientReg();
        clientReg.setClientAddress(clientRegDto.getClientAddress());
        clientReg.setPhoneNumber(clientRegDto.getPhoneNumber());
        clientReg.setClientName(clientRegDto.getClientName());
        clientReg.setGender(clientRegDto.getGender());
        clientReg.setEmail(clientRegDto.getEmail());
        clientReg.setUsername(clientRegDto.getUsername());
        clientReg.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));
        return clientReg;
    }
}
