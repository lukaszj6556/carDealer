package com.retail.business;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;

import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;

public class CarBusinessImpl implements CarBusiness {
    @Override
    public List<CarDto> computeCars(List<Car> cars) {
        List<CarDto> carsDto = new ArrayList<CarDto>();
        ModelMapper modelMapper = getMapper();
        for (Car car : cars) {
            System.out.println(car.toString());
            System.out.println("****");
            CarDto carDto = modelMapper.map(car, CarDto.class);
            carsDto.add(carDto);
            System.out.println(carDto.toString());

        }

        return carsDto;
    }

    private ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Car, CarDto> carMap = new PropertyMap<Car, CarDto>() {
            protected void configure() {
                map().setHorsePower(source.getCarDetails().getHorsePower());
                map().setColor(source.getCarDetails().getColor());
                map().setGearbox(source.getCarDetails().getGearbox());
                map().setEngineCapacity(source.getCarDetails().getEngineCapacity());
                map().setFuelType(source.getCarDetails().getFuelType());
                map().setVersion(source.getCarDetails().getVersion());
                map().setEngine(source.getCarDetails().getkWh());
                map().setName(source.getName());
            }
        };

        modelMapper.addMappings(carMap);

        return modelMapper;
    }
}
