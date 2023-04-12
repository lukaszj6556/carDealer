package com.retail.shop.car;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.retail.business.CarBusinessImpl;
import com.retail.business.CarBusiness;
import com.retail.services.CarServiceImpl;
import com.retail.services.CarService;
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
        System.out.println("Welcome to XYZ Car dealer. Please select from the below option to continue:");
        System.out.println("1. Check Car Inventory");
        System.out.println("2. Add New Car");
        System.out.println("3. Remove Existing Car");
        System.out.println("4. Update Car Details");
        System.out.println("5. Order New Car");
        int option = 0;
        ICarRepository carRepository = CarRepository.getInstance();

        CarService carService = new CarServiceImpl(carRepository);
        try 
        {
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("No option was choosen, closing the program");
        }

        switch(option)
        {
            case 1:
                System.out.println("This cars we have in our store:");
                List<Car> cars = carService.getAllCarsCars();
                CarBusiness carBusiness = new CarBusinessImpl();
                List<CarDto> carsDto = carBusiness.computeCars(cars);
                for (CarDto carDto : carsDto) {
                   System.out.println(carDto.getName());
                }
                break;
            default:
                System.out.println("No such option");
        }


    }
}
