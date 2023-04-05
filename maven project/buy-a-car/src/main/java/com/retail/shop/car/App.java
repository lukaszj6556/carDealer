package com.retail.shop.car;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.business.CarBusiness;
import com.retail.business.ICarBusiness;
import com.retail.services.CarService;
import com.retail.services.ICarService;
import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;
import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.CarDetails;
import com.retail.shop.car.repository.CarRepository;
import com.retail.shop.car.repository.ICarRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        ICarRepository carRepository = CarRepository.getInstance();

        ICarService carService = new CarService(carRepository);
        List<Car> cars = carService.GetAllCarsCars();
        ICarBusiness carBusiness = new CarBusiness();
        List<CarDto> carsDto = carBusiness.ComputeCars(cars);
        for (CarDto carDto : carsDto) {
           System.out.println(carDto.getName());
        }
    }
}
