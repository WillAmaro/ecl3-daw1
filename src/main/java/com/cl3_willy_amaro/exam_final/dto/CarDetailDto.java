package com.cl3_willy_amaro.exam_final.dto;


public record CarDetailDto(Integer id,
                           String make,
                           String model,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           String color) {
}
