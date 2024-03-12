package com.company.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Long[] idGift;
    private String name;
}
