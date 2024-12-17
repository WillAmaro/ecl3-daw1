package com.cl3_willy_amaro.exam_final.service;

import com.cl3_willy_amaro.exam_final.dto.CarDetailDto;
import com.cl3_willy_amaro.exam_final.dto.CarDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int carId) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
