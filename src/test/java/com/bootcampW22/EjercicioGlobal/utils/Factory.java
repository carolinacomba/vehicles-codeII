package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    List<Vehicle> vehicles = new ArrayList<>(
            List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0),
                    new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0),
                    new Vehicle(3L, "Fiat", "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0),
                    new Vehicle(4L, "Tesla", "Model S", "AF900DF", "Black", 2017, "210", 4, "gas", "manual", 140.0, 190.0, 1680.0),
                    new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                    new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0))
    );

    public static String getVehicleDtoByColorAndYear() throws JsonProcessingException {
        List<VehicleDto> expected = List.of(VehicleDto.builder()
                .id(1L)
                .brand("Ford")
                .model("Mustang")
                .registration("AB123CD")
                .year(2021)
                .color("Red")
                .max_speed("250")
                .fuel_type("gasoline")
                .transmission("automatic")
                .passengers(4)
                .height(140.0)
                .width(191.0)
                .weight(1680.0)
                .build());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expected);
    }

    public static String getVehiclesByColorAndRangeOfYear() throws JsonProcessingException {
        List<VehicleDto> expected = List.of(VehicleDto.builder()
                .id(2L)
                .brand("Chevrolet")
                .model("Camaro")
                .registration("AC123AB")
                .year(2020)
                .color("Red")
                .max_speed("290")
                .fuel_type("gasoline")
                .transmission("automatic")
                .passengers(4)
                .height(145.0)
                .width(198.0)
                .weight(1750.0)
                .build());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expected);
    }

    public static String getAverageSpeedByBrand() throws JsonProcessingException {
        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(230.0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expected);
    }

    public static String getAverageCapacityByBrand() throws JsonProcessingException {
        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(4.0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expected);
    }

    public static String getVehiclesByRangeOfWeight() throws JsonProcessingException {
        List<VehicleDto> expected = List.of(VehicleDto.builder()
                .id(3L)
                .brand("Fiat")
                .model("Cronos")
                .registration("AA123AN")
                .year(2015)
                .color("Blue")
                .max_speed("200")
                .fuel_type("gas")
                .transmission("manual")
                .passengers(3)
                .height(130.0)
                .width(191.0)
                .weight(1580)
                .build());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(expected);
    }
}
