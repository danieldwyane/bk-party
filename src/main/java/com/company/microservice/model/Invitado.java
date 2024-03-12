package com.company.microservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Invitado")
public class Invitado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guest_name")
    private String guestName;

    @ManyToOne
    @JoinColumn(name = "REGALOS_ID", referencedColumnName = "ID", nullable = false)
    private Regalos regalos;

}