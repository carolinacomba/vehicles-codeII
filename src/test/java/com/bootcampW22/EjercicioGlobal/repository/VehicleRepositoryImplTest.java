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
    void testFindVehiclesByBrand() {
        String brand = "Ford";
        List<Vehicle> expected = new ArrayList<>(List.of(
                new Vehicle(1L, brand, "Mustang", "AB123CD", "Red", 2022, "250", 4, "gasoline", "automatic", 140.3, 191.5, 1680.5)
        ));

        List<Vehicle> result = mockRepository.findVehiclesByBrand(brand);

        assertEquals(expected, result);
    }

}