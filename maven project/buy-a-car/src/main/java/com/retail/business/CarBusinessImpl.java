package com.retail.business;

import java.util.ArrayList;
import java.util.List;

import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;

public class CarBusinessImpl implements CarBusiness {
    @Override
    public List<CarDto> computeCars(List<Car> cars)
    {
        List<CarDto> carsDto = new ArrayList<CarDto>();
        double hpToKw = 0.74;

        for (Car car : cars) {
            CarDto carDto = new CarDto();
            carDto.setName(car.getBrand() + " " + car.getModel());
            carDto.setEngine(car.getCarDetails().getHorsePower() * hpToKw);
            carDto.setCarKilometres(car.getCarKilometres());
            carDto.setColor(car.getCarDetails().getColor());
            carDto.setFuelType(car.getCarDetails().getFuelType());
            carDto.setGearbox(car.getCarDetails().getGearbox());
            carDto.setPrice(car.getPrice());
            carDto.setProductionYear(car.getProductionYear());
            carDto.setVersion(car.getCarDetails().getVersion());
            carsDto.add(carDto);
        }

        return carsDto;
    }
}
