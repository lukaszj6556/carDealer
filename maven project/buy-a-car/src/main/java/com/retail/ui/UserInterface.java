package com.retail.ui;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import com.retail.business.CarBusiness;
import com.retail.business.CarBusinessImpl;
import com.retail.services.CarService;
import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;
import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.CarDetails;

public class UserInterface {

    private static final PrintStream OUT = System.out;

    public static void showMenu(CarService carService, ConsoleInteraction consoleInteraction) {
        printOptions();
        int option = 0;

        option = consoleInteraction.readNumber("Please choose option.");

        switch (option) {
            case 1:
                OUT.println("This cars we have in our store:");
                List<CarDto> cars = showAllCars(carService);
                OUT.println("Sort car by.");
                List<String> sortedCars = sortList(cars, consoleInteraction);
                showSortedCars(sortedCars);
                break;
            case 2:
                OUT.println("Adding new car. Please provide data of the car.");
                Car car = getCarFromUser(consoleInteraction);
                carService.addCar(car);
                break;
            case 3:
                OUT.println("Removing car.");
                showAllCars(carService);
                int idCarToRemove = consoleInteraction
                        .readNumber("Please provide id of the car you would like to remove:");
                carService.remove(idCarToRemove);
                break;
            case 4:
                OUT.println("Searching for a car.");
                String search = consoleInteraction.readString("Please provide the name of the car:");
                searchByName(search, carService);
                break;
            default:
                OUT.println("No such option");
        }
    }

    private static void printOptions() {
        OUT.println("Welcome to XYZ Car dealer. Please select from the below option to continue:");
        OUT.println("1. Check Car Inventory");
        OUT.println("2. Add New Car");
        OUT.println("3. Remove Existing Car");
        OUT.println("4. Search for Car");
        OUT.println("5. Order New Car");
    }

    private static List<String> sortList(List<CarDto> cars, ConsoleInteraction consoleInteraction) {
        OUT.println("How would like to sort the list?");
        OUT.println("1. By name");
        OUT.println("2. By price");
        OUT.println("3. By production Year");
        int option = consoleInteraction.readNumber("Please provide how the cars should be sorted.");
        switch (option) {
            case 1:
                return cars.stream().sorted((x, y) -> x.getName().compareTo(y.getName())).map(CarDto::getName)
                        .collect(Collectors.toList());
            case 2:
                cars.sort((x, y) -> Double.compare(x.getPrice(), y.getPrice()));
                return cars.stream().map(x -> x.getName() + " " + x.getPrice()).collect(Collectors.toList());
            case 3:
                cars.sort((x, y) -> Double.compare(x.getProductionYear(), y.getProductionYear()));
                return cars.stream().map(x -> x.getName() + " " + x.getProductionYear()).collect(Collectors.toList());
            default:
                return cars.stream().map(CarDto::getName).collect(Collectors.toList());
        }
    }

    private static Car getCarFromUser(ConsoleInteraction consoleInteraction) {
        Car car = new Car();
        car.setBrand(consoleInteraction.readString("Please provide brand name:"));
        car.setModel(consoleInteraction.readString("Please provide model name:"));
        car.setPrice(consoleInteraction.readNumber("Please provide price:"));
        car.setProductionYear(consoleInteraction.readNumber("Please provide production year:"));
        car.setCarKilometres(consoleInteraction.readNumber("How many kilometers it has?"));
        CarDetails details = new CarDetails();
        details.setColor(consoleInteraction.readString("Please provide color:"));
        details.setVersion(consoleInteraction.readString("Please provide version:"));
        details.setEngineCapacity(consoleInteraction.readFloatNumber("Please provide engine capacity:"));
        details.setFuelType(readFuelType(consoleInteraction));
        details.setGearbox(readGerBox(consoleInteraction));
        details.setHorsePower(consoleInteraction.readNumber("Please provide horsw power:"));
        car.setCarDetails(details);

        return car;
    }

    private static FuelTypeEnum readFuelType(ConsoleInteraction consoleInteraction) {
        OUT.println("Please provide fuel type:");
        OUT.println("1. " + FuelTypeEnum.DIESEL);
        OUT.println("2. " + FuelTypeEnum.PETROL);
        OUT.println("3. " + FuelTypeEnum.HYBRID);
        OUT.println("4. " + FuelTypeEnum.ELECTRIC);

        int type = consoleInteraction.readNumber("Choose type:");
        switch (type) {
            case 1:
                return FuelTypeEnum.DIESEL;
            case 2:
                return FuelTypeEnum.PETROL;
            case 3:
                return FuelTypeEnum.HYBRID;
            case 4:
                return FuelTypeEnum.ELECTRIC;
            default:
                OUT.println("Didn't find any option, chooseing petrol as default");
                return FuelTypeEnum.PETROL;
        }
    }

    private static GearBoxEnum readGerBox(ConsoleInteraction consoleInteraction) {
        OUT.println("Please provide gerabox type:");
        OUT.println("1. " + GearBoxEnum.Automatic);
        OUT.println("2. " + GearBoxEnum.Manual);

        int type = consoleInteraction.readNumber("Choose type:");
        switch (type) {
            case 1:
                return GearBoxEnum.Automatic;
            case 2:
                return GearBoxEnum.Manual;
            default:
                OUT.println("Didn't find any option, chooseing automtaic as default");
                return GearBoxEnum.Automatic;
        }
    }

    private static List<CarDto> showAllCars(CarService carService) {
        List<Car> cars = carService.getAllCarsCars();
        CarBusiness carBusiness = new CarBusinessImpl();
        List<CarDto> carsDto = carBusiness.computeCars(cars);
        for (CarDto carDto : carsDto) {
            OUT.println(carDto.toString());
        }

        return carsDto;
    }

    private static void showAllCars(List<CarDto> cars) {
        for (CarDto carDto : cars) {
            OUT.println(carDto.toString());
        }
    }

    private static void showSortedCars(List<String> cars) {
        for (String car : cars) {
            OUT.println(car);
        }
    }

    private static void searchByName(String search, CarService carService) {
        List<Car> cars = carService.getAllCarsCars();
        CarBusiness carBusiness = new CarBusinessImpl();
        List<CarDto> carsDto = carBusiness.computeCars(cars);
        List<CarDto> filteredCars = carsDto.stream().filter(
                x -> x.getName()
                        .toLowerCase()
                        .contains(search.toLowerCase()))
                .collect(Collectors.toList());
        for (CarDto carDto : filteredCars) {
            OUT.println(carDto.toString());
        }
    }
}
