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
        //Arrange
        String expected = Factory.getVehicleDtoByColorAndYear();
        String color = "Red";
        int year = 2021;

        //Act and Assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getVehiclesByColorAndYear_NotFoundTest() throws Exception {
        //Arrange
        String color = "Blue";
        int year = 1900;

        //Act and Assert
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andExpect(status().isNotFound());
    }

    @Test
    void getVehiclesByColorAndRangeOfYearTest() throws Exception {
        //Arrange
        String brand = "Chevrolet";
        int startYear = 2019;
        int endYear = 2021;
        String expected = Factory.getVehiclesByColorAndRangeOfYear();

        //Act and Assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand, startYear, endYear))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getVehiclesByColorAndRangeOfYear_NotFoundTest() throws Exception {
        //Arrange
        String brand = "BMW";
        int startYear = 1000;
        int endYear = 2000;

        //Act and Assert
        mockMvc.perform(get("/color/{color}/year/{year}", brand, startYear, endYear))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAverageSpeedByBrandTest() throws Exception {
        //Arrange
        String brand = "BMW";
        String expected = Factory.getAverageSpeedByBrand();

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getAverageSpeedByBrand_NotFoundTest() throws Exception {
        //Arrange
        String brand = "NoExiste";

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAverageCapacityByBrandTest() throws Exception {
        //Arrange
        String brand = "BMW";
        String expected = Factory.getAverageCapacityByBrand();

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getAverageCapacityByBrand_NotFoundTest() throws Exception {
        //Arrange
        String brand = "NoExiste";

        //Act and Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andExpect(status().isNotFound());
    }

    @Test
    void getVehiclesByRangeOfWeightTest() throws Exception {
        //Arrange
        double min = 1579.0;
        double max = 1581.0;
        String expected = Factory.getVehiclesByRangeOfWeight();

        //Act and Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(min))
                        .param("max", String.valueOf(max)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

    @Test
    void getVehiclesByRangeOfWeight_NotFoundTest() throws Exception {
        //Arrange
        double min = 1000.0;
        double max = 1001.0;

        //Act and Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(min))
                        .param("max", String.valueOf(max)))
                .andExpect(status().isNotFound());
    }
}