package com.company.microservice.repository;

import com.company.microservice.model.Regalos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegalosRepository extends JpaRepository<Regalos, Long> {
    List<Regalos> findAllByQuantityGreaterThan(int quantity);
}
