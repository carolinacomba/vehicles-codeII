package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleRepositoryImplTest {

    private VehicleRepositoryImpl mockRepository;

    @BeforeEach
    void setUp() throws IOException {
        mockRepository = new VehicleRepositoryImpl();
        mockRepository.loadDataBase();
    }

    @Test
    void findAllTest() {
        List<Vehicle> expected = new ArrayList<>(
                List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0),
                        new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0),
                        new Vehicle(3L, "Fiat", "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0),
                        new Vehicle(4L, "Tesla", "Model S", "AF900DF", "Black", 2017, "210", 4, "gas", "manual", 140.0, 190.0, 1680.0),
                        new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                        new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0))
        );

        List<Vehicle> result = mockRepository.findAll();

        assertEquals(expected, result);
    }

    @Test
    void findVehiclesByBrandTest() {
        String brand = "Ford";
        List<Vehicle> expected = new ArrayList<>(List.of(
                new Vehicle(1L, brand, "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0)
        ));

        List<Vehicle> result = mockRepository.findVehiclesByBrand(brand);

        assertEquals(expected, result);
    }

    @Test
    void findVehiclesByYearAndColorTest() {
        String color = "Red";
        int year = 2020;

        List<Vehicle> expected = new ArrayList<>(List.of(
                new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", color, year, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0)
        ));

        List<Vehicle> result = mockRepository.findVehiclesByYearAndColor(color, year);

        assertEquals(expected, result);
    }

    @Test
    void findVehiclesByBrandAndRangeOfYearTest() {
        String brand = "Fiat";
        int starYear = 2000;
        int endYear = 2020;

        List<Vehicle> expected = new ArrayList<>(List.of(
                new Vehicle(3L, brand, "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0)
        ));

        List<Vehicle> result = mockRepository.findVehiclesByBrandAndRangeOfYear(brand, starYear, endYear);

        assertEquals(expected, result);
    }

    @Test
    void findVehiclesByRangeOfWeightTest() {
        double weightMin = 1100.0;
        double weightMax = 1200.0;

        List<Vehicle> expected = new ArrayList<>(List.of(
                new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0)
        ));

        List<Vehicle> result = mockRepository.findVehiclesByRangeOfWeight(weightMin, weightMax);

        assertEquals(expected, result);
    }

}