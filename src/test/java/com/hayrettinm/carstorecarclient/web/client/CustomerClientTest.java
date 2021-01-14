package com.hayrettinm.carstorecarclient.web.client;

import com.hayrettinm.carstorecarclient.web.model.CarDto;
import com.hayrettinm.carstorecarclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCarById() {

        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        URI uri = customerClient.saveNewCar(customerDto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Updated Customer").build();

        customerClient.updateCustomer(customerDto.getId(),customerDto);
    }

    @Test
    void testDeleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}