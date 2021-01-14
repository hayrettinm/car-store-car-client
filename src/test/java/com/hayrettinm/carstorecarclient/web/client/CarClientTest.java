package com.hayrettinm.carstorecarclient.web.client;

import com.hayrettinm.carstorecarclient.web.model.CarDto;
import com.hayrettinm.carstorecarclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarClientTest {

    @Autowired
    CarClient carClient;

    @Test
    void getCarById() {

        CarDto dto = carClient.getCarById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCar() {

        CarDto carDto = CarDto.builder().carName("Clio IV").build();
        URI uri = carClient.saveNewCar(carDto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateCar() {

        CarDto carDto = CarDto.builder().id(UUID.randomUUID()).carName("Clio IV").build();

        carClient.updateCar(carDto.getId(),carDto);
    }

    @Test
    void testDeleteCar() {
        carClient.deleteCar(UUID.randomUUID());
    }
}