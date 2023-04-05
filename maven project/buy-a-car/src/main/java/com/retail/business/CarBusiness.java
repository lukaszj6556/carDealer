package com.retail.business;

import java.util.ArrayList;
import java.util.List;

import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;

public class CarBusiness implements ICarBusiness {
    @Override
    public List<CarDto> ComputeCars(List<Car> cars)
    {
        List<CarDto> carsDto = new ArrayList<CarDto>();

        for (Car car : cars) {
            CarDto carDto = new CarDto();
            carDto.setName(car.getBrand() + " " + car.getModel());
            carDto.setEngine("HorsePower: " + car.getCarDetails().getHorsePower() + " Engine capactiy:" +car.getCarDetails().getEngineCapacity());
            carsDto.add(carDto);
        }

        return carsDto;
    }
}
