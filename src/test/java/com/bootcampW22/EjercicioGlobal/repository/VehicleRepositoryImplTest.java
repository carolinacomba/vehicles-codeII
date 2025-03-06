package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleRepositoryImplTest {
    private VehicleRepositoryImpl vehicleRepository;

    @BeforeEach
    void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
        vehicleRepository.loadDataBase();
    }

    @Test
    void findVehiclesByYearAndColorTest() {
        //Arrange
        List<Vehicle> expected = List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0));

        //Act
        List<Vehicle> result = vehicleRepository.findVehiclesByBrand("Ford");

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void findVehiclesByBrandAndRangeOfYearTest() {
        //Arrange
        List<Vehicle> expected = List.of(new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0));

        //Act
        List<Vehicle> actual = vehicleRepository.findVehiclesByBrandAndRangeOfYear("Chevrolet", 2018, 2022);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void findVehiclesByBrandTest() {
        //Arrange
        List<Vehicle> expected = List.of(new Vehicle(3L, "Fiat", "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0));

        //Act
        List<Vehicle> actual = vehicleRepository.findVehiclesByBrand("Fiat");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void findVehiclesByRangeOfWeightTest() {
        //Arrange
        List<Vehicle> expected = List.of(
                new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0),
                new Vehicle(4L, "Tesla", "Model S", "AF900DF", "Black", 2017, "210", 4, "gas", "manual", 140.0, 190.0, 1680.0)
        );

        //Act
        List<Vehicle> actual = vehicleRepository.findVehiclesByRangeOfWeight(1600.0, 1700.0);

        //Assert
        assertEquals(expected, actual);
    }

//    List<Vehicle> vehicles = new ArrayList<>(
//            List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0),
//                    new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0),
//                    new Vehicle(3L, "Fiat", "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0),
//                    new Vehicle(4L, "Tesla", "Model S", "AF900DF", "Black", 2017, "210", 4, "gas", "manual", 140.0, 190.0, 1680.0),
//                    new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
//                    new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0))
//    );
}