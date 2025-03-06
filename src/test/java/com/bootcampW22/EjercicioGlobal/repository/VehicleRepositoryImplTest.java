package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

class VehicleRepositoryImplTest {
    List<Vehicle> vehicles = new ArrayList<>(
            List.of(new Vehicle(1L, "Ford", "Mustang", "AB123CD", "Red", 2021, "250", 4, "gasoline", "automatic", 140.0, 191.0, 1680.0),
                    new Vehicle(2L, "Chevrolet", "Camaro", "AC123AB", "Red", 2020, "290", 4, "gasoline", "automatic", 145.0, 198.0, 1750.0),
                    new Vehicle(3L, "Fiat", "Cronos", "AA123AN", "Blue", 2015, "200", 3, "gas", "manual", 130.0, 191.0, 1580.0),
                    new Vehicle(4L, "Tesla", "Model S", "AF900DF", "Black", 2017, "210", 4, "gas", "manual", 140.0, 190.0, 1680.0),
                    new Vehicle(5L, "BMW", "X5", "AD567HH", "White", 2022, "240", 5, "gas", "automatic", 150.0, 151.0, 1180.0),
                    new Vehicle(6L, "BMW", "T5", "AC000CV", "Black", 2004, "220", 3, "gas", "automatic", 150.0, 151.0, 1180.0))
    );
}