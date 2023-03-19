package com.retail.shop.car;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.CarDetails;
import com.retail.shop.car.repository.CarRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        System.out.println( "Hello World!" );
        // Car carToAdd = new Car(4, "Ford", "Focus", 2000, 34562, 23000);
        // carToAdd.setCarDetails(new CarDetails("green", "Simple", 100, 1.0, GearBoxEnum.Manual, FuelTypeEnum.Diesel));
        CarRepository carRepository = new CarRepository();
        // carRepository.AddCar(carToAdd);
        carRepository.Remove(1);
        List<Car> car = carRepository.GetAllCars();
        System.out.println(car.toString());

    }
}
