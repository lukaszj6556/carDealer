package com.retail.shop.car;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

public class App 
{
    static Scanner scanner = new Scanner(System.in);
    static CarService carService = new CarServiceImpl();

    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        PrintOptions();
        int option = 0;

        option = readNumber("Please choose option.");

        switch(option)
        {
            case 1:
                System.out.println("This cars we have in our store:");
                List<CarDto> cars = showAllCars();
                System.out.println("Sort car by.");
                List<String> sortedCars = SortList(cars);
                showSortedCars(sortedCars);
                break;
            case 2:
                System.out.println("Adding new car. Please provide data of the car.");
                Car car = getCarFromUser();
                carService.addCar(car);
                break;
            case 3:
                System.out.println("Removing car.");
                showAllCars();
                int idCarToRemove = readNumber("Please provide id of the car you would like to remove:");
                carService.remove(idCarToRemove);
                break;
            case 4:
                System.out.println("Searching for a car.");
                String search = ReadString("Please provide the name of the car:");
                searchByName(search);
            default:
                System.out.println("No such option");
        }
    }

    private static void PrintOptions()
    {
        System.out.println("Welcome to XYZ Car dealer. Please select from the below option to continue:");
        System.out.println("1. Check Car Inventory");
        System.out.println("2. Add New Car");
        System.out.println("3. Remove Existing Car");
        System.out.println("4. Search for Car");
        System.out.println("5. Order New Car");
    }

    private static List<String> SortList(List<CarDto> cars)
    {
        System.out.println("How would like to sort the list?");
        System.out.println("1. By name");
        System.out.println("2. By price");
        System.out.println("3. By production Year");
        int option = readNumber("Please provide how the cars should be sorted.");
        switch(option)
        {
            case 1:
                return cars.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).map(x -> x.getName()).collect(Collectors.toList());
            case 2:
                cars.sort((x,y) -> Double.compare(x.getPrice(), y.getPrice()));
                return cars.stream().map(x -> x.getName() + " " + x.getPrice()).collect(Collectors.toList());
            case 3:
                cars.sort((x,y) -> Double.compare(x.getProductionYear(), y.getProductionYear()));
                return cars.stream().map(x -> x.getName() + " " + x.getProductionYear()).collect(Collectors.toList());
            default:
                return cars.stream().map(x -> x.getName()).collect(Collectors.toList());
        }
    }

    private static Car getCarFromUser()
    {
        Car car = new Car();
        car.setBrand(ReadString("Please provide brand name:"));
        car.setModel(ReadString("Please provide model name:"));
        car.setPrice(readNumber("Please provide price:"));
        car.setProductionYear(readNumber("Please provide production year:"));
        car.setCarKilometres(readNumber("How many kilometers it has?"));
        CarDetails details = new CarDetails();
        details.setColor(ReadString("Please provide color:"));
        details.setVersion(ReadString("Please provide version:"));
        details.setEngineCapacity(readFloatNumber("Please provide engine capacity:"));
        details.setFuelType(readFuelType());
        details.setGearbox(readGerBox());
        details.setHorsePower(readNumber("Please provide horsw power:"));
        car.setCarDetails(details);

        return car;
    }

    private static String ReadString(String text)
    {
        String s = "";
        System.out.println(text);
        s = scanner.next();

        return s;
    }

    private static int readNumber(String text)
    {
        int number = 0;
        System.out.println(text);
        try 
        {
            number = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("What you have provided is not a number. Please try again.");
            readNumber(text);
        }

        return number;
    }

    private static float readFloatNumber(String text)
    {
        float number = 0;
        System.out.println(text);
        try 
        {
            number = scanner.nextFloat();
        }
        catch(Exception e)
        {
            System.out.println("What you have provided is not a number. Please try again.");
            readNumber(text);
        }

        return number;
    }

    private static FuelTypeEnum readFuelType()
    {
        System.out.println("Please provide fuel type:");
        System.out.println("1. " + FuelTypeEnum.Diesel);
        System.out.println("2. " + FuelTypeEnum.Petrol);
        System.out.println("3. " + FuelTypeEnum.Hybrid);
        System.out.println("4. " + FuelTypeEnum.Electric);
        
        int type = readNumber("Choose type:");
        switch(type)
        {
            case 1:
                return FuelTypeEnum.Diesel;
            case 2:
                return FuelTypeEnum.Petrol;
            case 3:
                return FuelTypeEnum.Hybrid;
            case 4:
                return FuelTypeEnum.Electric;
            default:
                System.out.println("Didn't find any option, chooseing petrol as default");
                return FuelTypeEnum.Petrol;
        }
    }

    private static GearBoxEnum readGerBox()
    {
        System.out.println("Please provide gerabox type:");
        System.out.println("1. " + GearBoxEnum.Automatic);
        System.out.println("2. " + GearBoxEnum.Manual);
        
        int type = readNumber("Choose type:");
        switch(type)
        {
            case 1:
                return GearBoxEnum.Automatic;
            case 2:
                return GearBoxEnum.Manual;
            default:
                System.out.println("Didn't find any option, chooseing automtaic as default");
                return GearBoxEnum.Automatic;
        }
    }

    private static List<CarDto> showAllCars()
    {
        List<Car> cars = carService.getAllCarsCars();
        CarBusiness carBusiness = new CarBusinessImpl();
        List<CarDto> carsDto = carBusiness.computeCars(cars);
        for (CarDto carDto : carsDto) {
           System.out.println(carDto.toString());
        }

        return carsDto;
    }

    private static void showAllCars( List<CarDto> cars)
    {
        for (CarDto carDto : cars) {
           System.out.println(carDto.toString());
        }
    }

    private static void showSortedCars(List<String> cars)
    {
        for (String car : cars) {
            System.out.println(car);
         }
    }

    private static void searchByName(String search)
    {
        List<Car> cars = carService.getAllCarsCars();
        CarBusiness carBusiness = new CarBusinessImpl();
        List<CarDto> carsDto = carBusiness.computeCars(cars);
        List<CarDto> filteredCars = carsDto.stream().filter(
            x -> x.getName()
                .toLowerCase()
                .contains(search.toLowerCase()))
            .collect(Collectors.toList());
        for (CarDto carDto : filteredCars) {
            System.out.println(carDto.toString());
        }
    }
}
