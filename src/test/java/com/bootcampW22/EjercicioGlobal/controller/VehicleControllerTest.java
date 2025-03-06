package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.utils.Factory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getVehiclesByColorAndYear() throws Exception {
        //Arrange
        String expected = Factory.getVehicleDtoByColorAndYear();

        //Act and Assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", "Red", 2021))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getVehiclesByColorAndRangeOfYear() throws Exception {
        //Arrange
        String expected = Factory.getVehiclesByColorAndRangeOfYear();

        //Act and Assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", "Chevrolet", 2019, 2021))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getAverageSpeedByBrand() throws Exception {
        //Arrange
        String expected = Factory.getAverageSpeedByBrand();

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", "BMW"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getAverageCapacityByBrand() throws Exception {
        //Arrange
        String expected = Factory.getAverageCapacityByBrand();

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", "BMW"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getVehiclesByRangeOfWeight() throws Exception {
        //Arrange
        String expected = Factory.getVehiclesByRangeOfWeight();

        //Act and Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", "1579.0")
                        .param("max", "1581.0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }
}