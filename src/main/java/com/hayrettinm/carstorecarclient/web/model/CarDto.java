package com.hayrettinm.carstorecarclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private UUID id;
    private String carName;
    private String carStyle;
    private Long chasisNo;
}
