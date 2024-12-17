package com.cl3_willy_amaro.exam_final.response;
import com.cl3_willy_amaro.exam_final.dto.CarDto;

public record FindCars (String code,
        String error,
        Iterable<CarDto> cars) {
        }
