package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository iVehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchVehiclesByYearAndColor() {
        // Arrange
        List<Vehicle> expected = List.of(
                new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2000, "180 km/h", 5, "Gasoline", "Automatic", 1.45, 1.75, 1300),
                new Vehicle(2L, "Ford", "Focus", "DEF456", "Red", 2000, "200 km/h", 5, "Diesel", "Manual", 1.42, 1.79, 1400),
                new Vehicle(3L, "Honda", "Civic", "GHI789", "Red", 2000, "190 km/h", 5, "Hybrid", "Automatic", 1.43, 1.80, 1350)
        );

        when(iVehicleRepository.findVehiclesByYearAndColor("Red", 2000)).thenReturn(expected);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("Red", 2000);

        // Assert
        assertEquals(3, result.size());
        assertEquals("Toyota", result.get(0).getBrand());
        assertEquals("Ford", result.get(1).getBrand());
        assertEquals("Honda", result.get(2).getBrand());
    }

    @Test
    void searchVehiclesByBrandAndRangeOfYear() {
    }

    @Test
    void calculateAvgSpeedByBrand() {
    }

    @Test
    void calculateAvgCapacityByBrand() {
    }

    @Test
    void searchVehiclesByRangeOfWeight() {
    }
}