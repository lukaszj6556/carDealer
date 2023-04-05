package com.retail.business;

import java.util.List;

import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;

public interface ICarBusiness {

    List<CarDto> ComputeCars(List<Car> cars);
}