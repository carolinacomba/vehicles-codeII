package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
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
    IVehicleRepository iVehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchAllVehicles() {
        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(2L, "Ford", "Focus", "DEF456", "Red", 2000, "200", 5, "Diesel", "Manual", 1.42, 1.79, 1400),
                new Vehicle(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        when(iVehicleRepository.findAll()).thenReturn(vehiclesEntity);

        List<VehicleDto> expected = new ArrayList<>(List.of(
                new VehicleDto(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new VehicleDto(2L, "Ford", "Focus", "DEF456", "Red", 2000, "200", 5, "Diesel", "Manual", 1.42, 1.79, 1400),
                new VehicleDto(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        List<VehicleDto> actual = vehicleService.searchAllVehicles();

        assertEquals(expected, actual);
    }

    @Test
    void searchAllVehiclesWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findAll()).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.searchAllVehicles());
    }

    @Test
    void searchVehiclesByYearAndColor() {
        // Arrange
        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(2L, "Ford", "Focus", "DEF456", "Red", 2000, "200", 5, "Diesel", "Manual", 1.42, 1.79, 1400),
                new Vehicle(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        List<VehicleDto> expected = new ArrayList<>(List.of(
                new VehicleDto(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new VehicleDto(2L, "Ford", "Focus", "DEF456", "Red", 2000, "200", 5, "Diesel", "Manual", 1.42, 1.79, 1400),
                new VehicleDto(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        when(iVehicleRepository.findVehiclesByYearAndColor("Red", 2000)).thenReturn(vehiclesEntity);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("Red", 2000);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void searchVehiclesByYearAndColorWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findVehiclesByYearAndColor("red", 2000)).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor("red", 2000));
    }

    @Test
    void searchVehiclesByBrandAndRangeOfYear() {
        String brand = "Toyota";
        int minYear = 2000;
        int maxYear = 2010;

        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, brand, "Corolla", "ABC123", "Red", 2002, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300)
        ));
        List<VehicleDto> expected = new ArrayList<>(List.of(
                new VehicleDto(1L, brand, "Corolla", "ABC123", "Red", 2002, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300)
        ));


        when(iVehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, minYear, maxYear)).thenReturn(vehiclesEntity);

        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, minYear, maxYear);

        assertEquals(expected, result);
    }

    @Test
    void searchVehiclesByBrandAndRangeOfYearWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findVehiclesByBrandAndRangeOfYear("toyota", 2000, 2004)).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByBrandAndRangeOfYear("toyota", 2000, 2004));
    }

    @Test
    void calculateAvgSpeedByBrand() {
        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "100", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(2L, "Toyota", "Focus", "DEF456", "Red", 2000, "200", 5, "Diesel", "Manual", 1.42, 1.79, 1400)

        ));
        when(iVehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehiclesEntity);

        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(150.0);

        VehicleAvgSpeedByBrandDto actual = vehicleService.calculateAvgSpeedByBrand("Toyota");

        assertEquals(expected, actual);
    }

    @Test
    void calculateAvgSpeedByBrandWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgSpeedByBrand("Toyota"));
    }

    @Test
    void calculateAvgCapacityByBrand() {
        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "100", 6, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(2L, "Toyota", "Focus", "DEF456", "Red", 2000, "200", 4, "Diesel", "Manual", 1.42, 1.79, 1400)

        ));
        when(iVehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehiclesEntity);

        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(5.0);

        VehicleAvgCapacityByBrandDto actual = vehicleService.calculateAvgCapacityByBrand("Toyota");

        assertEquals(expected, actual);
    }

    @Test
    void calculateAvgCapacityByBrandWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findVehiclesByBrand("Toyota")).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgCapacityByBrand("Toyota"));
    }

    @Test
    void searchVehiclesByRangeOfWeight() {
        double weightMin = 1200;
        double weightMax = 1400;

        List<Vehicle> vehiclesEntity = new ArrayList<>(List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        when(iVehicleRepository.findVehiclesByRangeOfWeight(weightMin, weightMax)).thenReturn(vehiclesEntity);

        List<VehicleDto> expected = new ArrayList<>(List.of(
                new VehicleDto(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new VehicleDto(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        ));

        List<VehicleDto> actual = vehicleService.searchVehiclesByRangeOfWeight(weightMin, weightMax);

        assertEquals(expected, actual);
    }

    @Test
    void searchVehiclesByRangeOfWeightWhenListIsEmpty() {
        List<Vehicle> vehicles = new ArrayList<>();

        when(iVehicleRepository.findVehiclesByRangeOfWeight(1000, 2000)).thenReturn(vehicles);

        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByRangeOfWeight(1000, 2000));
    }
}