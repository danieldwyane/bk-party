package com.company.microservice.repository;

import com.company.microservice.model.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitadoRepository extends JpaRepository<Invitado, Long> {

}
