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
    public List<CarDto> computeCars(List<Car> cars)
    {
        List<CarDto> carsDto = new ArrayList<CarDto>();
        ModelMapper modelMapper = getMapper();
          
        for (Car car : cars) {
            CarDto carDto = modelMapper.map(car, CarDto.class);
            carsDto.add(carDto);
        }

        return carsDto;
    }

    private ModelMapper getMapper()
    {
        Converter<String, String> converter = new Converter<String, String>() {
            public String convert(MappingContext<String, String> context) {
                Car car = (Car) context.getParent().getSource();
                CarDto carDto = (CarDto) context.getParent().getDestination();
                carDto.setName(car.getBrand() + " " + car.getModel());

                return car.getBrand() + car.getModel();
            }
          };

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(converter);
        PropertyMap<Car, CarDto> carMap = new PropertyMap<Car, CarDto>() {
            protected void configure() {
              map().setHorsePower(source.getCarDetails().getHorsePower());
              map().setColor(source.getCarDetails().getColor());
              map().setGearbox(source.getCarDetails().getGearbox());
              map().setEngineCapacity(source.getCarDetails().getEngineCapacity());
              map().setFuelType(source.getCarDetails().getFuelType());
              map().setVersion(source.getCarDetails().getVersion());
              map().setEngine(source.getCarDetails().getHorsePower() * 0.74);
            }
          };
          
          modelMapper.addMappings(carMap);

          return modelMapper;
    }
}
