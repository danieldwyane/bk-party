package com.company.microservice.service;

import com.company.microservice.dto.RequestDto;
import com.company.microservice.model.Invitado;
import com.company.microservice.model.Regalos;
import com.company.microservice.repository.InvitadoRepository;
import com.company.microservice.repository.RegalosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegalosService {
    @Autowired
    RegalosRepository regalosRepository;

    @Autowired
    InvitadoRepository invitadoRepository;

    public List<Regalos> findAll() {
        return regalosRepository.findAll();
    }

    public List<Regalos> findAvailable() {
        return regalosRepository.findAllByQuantityGreaterThan(0);
    }

    public void save(RequestDto requestDto) {
        Optional<Regalos> regalo = regalosRepository.findById(requestDto.getIdGift());
        if (regalo.isPresent()) {
            regalo.get().setQuantity(regalo.get().getQuantity() - 1);
        }
        regalosRepository.save(regalo.get());
        Invitado invitado = new Invitado();
        invitado.setGuestName(requestDto.getName());
        invitado.setRegalos(regalo.get());
        invitadoRepository.save(invitado);
    }
}