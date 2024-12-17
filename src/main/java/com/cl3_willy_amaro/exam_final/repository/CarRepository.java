package com.cl3_willy_amaro.exam_final.repository;

import org.springframework.data.repository.CrudRepository;
import  com.cl3_willy_amaro.exam_final.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
