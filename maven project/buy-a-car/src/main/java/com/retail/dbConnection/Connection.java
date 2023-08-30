package com.retail.dbConnection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.Dealer;

public class Connection {
    private static final String DATABASE_YAML = "database.yaml";
    MapperFactory mapperFactory;
    ObjectMapper mapper;
    private String path = "maven project/buy-a-car/src/main/resources/";
    private String filename = DATABASE_YAML;

    public Connection(MapperFactory mapperFactory) {
        setMapperFactory(mapperFactory);
    }

    public void setMapperFactory(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try {
            return mapper.readValue(ClassLoader.getSystemResourceAsStream(DATABASE_YAML), Dealer.class).getCars();
        } catch (IOException ex) {
            System.out.println(
                    "Problem with accessing files with data. Check if file database.yaml exists in folder resources."
                            + ex.getMessage());
        }

        return cars;
    }

    public void addCar(Car car) {
        try {
            Dealer dealer = getDealer();
            List<Car> cars = dealer.getCars();
            int index = cars.stream().mapToInt(x -> x.getId()).max().getAsInt();
            car.setId(index + 1);
            cars.add(car);
            dealer.setCars(cars);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(path, filename), dealer);
        } catch (Exception e) {
            System.out.println(
                    "Problem with accessing files with data. Check if file database.yaml exists in folder resources."
                            + e.getMessage());
        }
    }

    public Car getCarById(int id) {
        List<Car> cars = getAllCars();
        return cars.stream().filter(car -> car.getId() == id).findAny().get();
    }

    public void removeCar(int id) {
        try {
            Dealer dealer = getDealer();
            List<Car> cars = dealer.getCars();
            Car car = cars.stream().filter(x -> x.getId() == id).findAny().get();
            cars.remove(car);
            dealer.setCars(cars);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(path, filename), dealer);
        } catch (Exception e) {
            System.out.println(
                    "Problem with accessing files with data. Check if file database.yaml exists in folder resources."
                            + e.getMessage());
        }
    }

    private Dealer getDealer() {
        Dealer dealer = new Dealer();
        try {
            Dealer del = mapper.readValue(ClassLoader.getSystemResourceAsStream(DATABASE_YAML), Dealer.class);
            return del;
        } catch (IOException ex) {
            System.out.println(
                    "Problem with accessing files with data. Check if file database.yaml exists in folder resources."
                            + ex.getMessage());
        }

        return dealer;
    }
}
