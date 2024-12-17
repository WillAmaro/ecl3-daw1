package com.cl3_willy_amaro.exam_final.response;

import com.cl3_willy_amaro.exam_final.dto.CarDetailDto;

public record FindCarById (String code,
                           String error,
                           CarDetailDto car) {
        }
