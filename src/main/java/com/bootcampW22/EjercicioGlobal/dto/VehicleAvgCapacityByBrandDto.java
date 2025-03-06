package com.bootcampW22.EjercicioGlobal.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleAvgCapacityByBrandDto {
    @NotBlank
    private double average_capacity;
}
