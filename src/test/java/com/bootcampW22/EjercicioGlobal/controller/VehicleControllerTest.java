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
    void getVehiclesByColorAndYearTest() throws Exception {
        String expectedJson = Factory.getVehicleDtoByColorAndYear();

        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", "Red", 2021))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void getVehiclesByColorAndRangeOfYearTest() throws Exception {
        String expected = Factory.getVehiclesByColorAndRangeOfYear();

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", "Chevrolet", 2019, 2021))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getAverageSpeedByBrandTest() {
    }

    @Test
    void getAverageCapacityByBrandTest() {
    }

    @Test
    void getVehiclesByRangeOfWeightTest() throws Exception {
        String expected = Factory.getVehiclesByRangeOfWeight();
    }
}