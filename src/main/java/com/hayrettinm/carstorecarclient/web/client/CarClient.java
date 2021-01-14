package com.hayrettinm.carstorecarclient.web.client;

import com.hayrettinm.carstorecarclient.web.model.CarDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "hayrettinm.car", ignoreInvalidFields = false)
public class CarClient {

    public final String CAR_PATH_V1 = "/api/v1/car/";
    public final String CAR_PATH_V2 = "/api/v2/car/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public CarClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CarDto getCarById(UUID carId){
        return restTemplate.getForObject(apiHost + CAR_PATH_V1 + carId.toString(),CarDto.class);
    }

    public URI saveNewCar(CarDto carDto){
        return restTemplate.postForLocation(apiHost + CAR_PATH_V1, carDto);
    }

    public void updateCar(UUID carId, CarDto carDto){
        restTemplate.put(apiHost + CAR_PATH_V1 + carId.toString(), carDto);
    }

    public void deleteCar(UUID carId){
        restTemplate.delete(apiHost + CAR_PATH_V1 + carId.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
