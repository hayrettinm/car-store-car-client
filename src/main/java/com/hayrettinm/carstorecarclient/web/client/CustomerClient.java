package com.hayrettinm.carstorecarclient.web.client;

import com.hayrettinm.carstorecarclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "hayrettinm.customer", ignoreInvalidFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH = "/api/v1/customer/";

    private String apiHost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH + customerId.toString(),CustomerDto.class);
    }

    public URI saveNewCar(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_PATH + customerId.toString(), customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost + CUSTOMER_PATH + customerId.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
