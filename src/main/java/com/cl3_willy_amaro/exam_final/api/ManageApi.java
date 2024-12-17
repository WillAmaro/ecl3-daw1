package com.cl3_willy_amaro.exam_final.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cl3_willy_amaro.exam_final.dto.CarDetailDto;
import com.cl3_willy_amaro.exam_final.dto.CarDto;
import com.cl3_willy_amaro.exam_final.response.*;
import com.cl3_willy_amaro.exam_final.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCars findCars(@RequestParam(value = "id", defaultValue = "0") String id){

        try {
            if(Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = manageService.getAllCarsById(Integer.parseInt(id));
                if(optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCars("01", "", List.of(carDto));
                } else {
                    return new FindCars("02", "Carro no encontrado", null);
                }
            } else {
                List<CarDto> cars = manageService.getAllCars();
                if(!cars.isEmpty())
                    return new FindCars("01","", cars);
                else
                    return new FindCars("03","Carro no encontrado", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new FindCars("99","servicio no encontrado", null);
        }
    }


    @GetMapping("/detail")
    public FindCarById findCarByID(@RequestParam(value = "id", defaultValue = "0") String id){

        try {
            if(Integer.parseInt(id) > 0) {
                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
                if(optional.isPresent()) {
                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarById("01", "", carDetailDto);
                } else {
                    return new FindCarById("02", "Carro no encontrado", null);
                }

            } else {
                return new FindCarById("03","Parametro no encontrado", null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new FindCarById("99","servicio no encontrado", null);
        }
    }




    @PostMapping("/update")
    public UpdateCar updateCar(@RequestBody CarDto carDto) {

        try {
            if(manageService.updateCar(carDto)) {
                return new UpdateCar("01", "Carro actualizado correctamente");
            } else {
                return new UpdateCar("02", "carro no encontrado");
            }

        }catch (Exception e){
            e.printStackTrace();
            return new UpdateCar("99","servicio no encontrado");
        }
    }


    @DeleteMapping("/delete")
    public DeleteCarById deleteCarByID(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            int carId = Integer.parseInt(id);
            if (carId > 0) {
                boolean deleted = manageService.deleteCarById(carId);
                if (deleted) {
                    return new DeleteCarById("01", "Carro eliminado correctamente");
                } else {
                    return new DeleteCarById("02", "carro no encontrado");
                }
            } else {
                return new DeleteCarById("03", "Invalid parameter");
            }
        } catch (NumberFormatException e) {
            return new DeleteCarById("03", "Invalid parameter format");
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarById("99", "servicio no encontrado");
        }
    }

    @PostMapping("/create")
    public CreateCar createCar(@RequestBody CarDetailDto carDetailDto) {
        try {
            boolean created = manageService.addCar(carDetailDto);
            if (created) {
                return new CreateCar("01", "Carro creado ");
            } else {
                return new CreateCar("02", "Error al crear ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCar("99", "Error en el servicio");
        }
    }



}