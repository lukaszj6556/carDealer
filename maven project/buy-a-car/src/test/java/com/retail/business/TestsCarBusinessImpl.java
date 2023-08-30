package com.retail.business;

import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;
import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.CarDetails;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestsCarBusinessImpl {


    @Test
    public void testComputeCars() {
        //given
        CarDetails carDetails = new CarDetails();
        carDetails.setFuelType(FuelTypeEnum.PETROL);
        carDetails.setGearbox(GearBoxEnum.Automatic);
        carDetails.setColor("pink");
        carDetails.setEngineCapacity(2.0f);
        carDetails.setHorsePower(100);
        carDetails.setVersion("cosmic");
        Car car = new Car(1, "Fiat", "Dublo", 1987, 35000, 730);
        car.setCarDetails(carDetails);

        List<Car> cars = new ArrayList<Car>() {
            {
                add(car);
            }
        };
        CarDto carDto = new CarDto();
        carDto.setName("Fiat Dublo");
        carDto.setProductionYear(1987);
        carDto.setCarKilometres(35000);
        carDto.setPrice(730);
        carDto.setGearbox(GearBoxEnum.Automatic);
        carDto.setFuelType(FuelTypeEnum.PETROL);
        carDto.setColor("pink");
        carDto.setVersion("cosmic");
        carDto.setEngineCapacity(2.0f);
        carDto.setEngine(74);
        carDto.setHorsePower(100);
        List<CarDto> expectedCarsDto = new ArrayList<CarDto>() {
            {
                add(carDto);
            }
        };

        //when
        CarBusinessImpl carBusiness = new CarBusinessImpl();
        List<CarDto> carDtos = carBusiness.computeCars(cars);

        //then
        Assert.assertEquals(expectedCarsDto.get(0).getCarKilometres(), carDtos.get(0).getCarKilometres());
        Assert.assertEquals(expectedCarsDto.get(0).getColor(), carDtos.get(0).getColor());
        Assert.assertEquals(expectedCarsDto.get(0).getHorsePower(), carDtos.get(0).getHorsePower(), 0.0f);
        Assert.assertEquals(expectedCarsDto.get(0).getEngine(), carDtos.get(0).getEngine(), 0.0f);
        Assert.assertEquals(expectedCarsDto.get(0).getGearbox(), carDtos.get(0).getGearbox());
        Assert.assertEquals(expectedCarsDto.get(0).getFuelType(), carDtos.get(0).getFuelType());
        Assert.assertEquals(expectedCarsDto.get(0).getName(), carDtos.get(0).getName());
        Assert.assertEquals(expectedCarsDto.get(0).getPrice(), carDtos.get(0).getPrice(), 0.0f);
        Assert.assertEquals(expectedCarsDto.get(0).getProductionYear(), carDtos.get(0).getProductionYear());
        Assert.assertEquals(expectedCarsDto.get(0).getVersion(), carDtos.get(0).getVersion());
        Assert.assertEquals(expectedCarsDto.get(0).getEngineCapacity(), carDtos.get(0).getEngineCapacity(), 0.0f);
    }
}
