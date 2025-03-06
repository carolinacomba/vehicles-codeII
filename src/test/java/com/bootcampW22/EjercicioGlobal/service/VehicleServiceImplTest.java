package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchVehiclesByYearAndColor() {
        //Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0));
        when(vehicleRepository.findVehiclesByYearAndColor("Red", 2021)).thenReturn(vehicles);
        List<VehicleDto> expected = List.of(new VehicleDto(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0));

        //Act
        List<VehicleDto> actual = vehicleService.searchVehiclesByYearAndColor("Red", 2021);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void searchVehiclesByYearAndColorWhenListIsEmpty() {
        //Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByYearAndColor("Red", 2021)).thenReturn(vehicles);

        //Act and Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor("Red", 2021));
    }

    @Test
    void searchVehiclesByBrandAndRangeOfYear() {
        //Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0));
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Chevrolet", 2019, 2021)).thenReturn(vehicles);
        List<VehicleDto> expected = List.of(new VehicleDto(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0));

        //Act
        List<VehicleDto> actual = vehicleService.searchVehiclesByBrandAndRangeOfYear("Chevrolet", 2019, 2021);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void searchVehiclesByBrandAndRangeOfYearWhenListIsEmpty() {
        //Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("BMW", 2000, 2001)).thenReturn(vehicles);

        //Act and Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByBrandAndRangeOfYear("BMW", 2000, 2001));
    }

    @Test
    void calculateAvgSpeedByBrand() {
        //Arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0)
        );
        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(230.0);
        when(vehicleRepository.findVehiclesByBrand("BMW")).thenReturn(vehicles);

        //Act
        VehicleAvgSpeedByBrandDto actual = vehicleService.calculateAvgSpeedByBrand("BMW");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateAvgSpeedByBrandWhenListIsEmpty() {
        //Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByBrand("asda")).thenReturn(vehicles);

        //Act and Assert
        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgCapacityByBrand("asda"));
    }

    @Test
    void calculateAvgCapacityByBrand() {
        //Arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0)
        );
        when(vehicleRepository.findVehiclesByBrand("BMW")).thenReturn(vehicles);
        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(4);

        //Act
        VehicleAvgCapacityByBrandDto actual = vehicleService.calculateAvgCapacityByBrand("BMW");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateAvgCapacityByBrandWhenListIsEmpty() {
        //Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByBrand("sdfs")).thenReturn(vehicles);

        //Act and Assert
        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgSpeedByBrand("sdfs"));
    }

    @Test
    void searchVehiclesByRangeOfWeight() {
        //Arrange
        List<Vehicle> vehicles = List.of(new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0));
        when(vehicleRepository.findVehiclesByRangeOfWeight(1749.0, 1751.0)).thenReturn(vehicles);
        List<VehicleDto> expected = List.of(new VehicleDto(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0));

        //Act
        List<VehicleDto> actual = vehicleService.searchVehiclesByRangeOfWeight(1749.0, 1751.0);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void searchVehiclesByRangeOfWeightWhenListIsEmpty() {
        //Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByRangeOfWeight(1, 2)).thenReturn(vehicles);

        //Act and Assert
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByRangeOfWeight(1, 2));
    }
}