package com.retail.Connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.business.CarBusinessImpl;
import com.retail.dbConnection.Connection;
import com.retail.dbConnection.MapperFactory;
import com.retail.shop.car.model.Car;
import com.retail.shop.car.model.Dealer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ ObjectMapper.class })
public class ConnectionsTest {
    public static List<Car> cars = new ArrayList<Car>() {
        {
            add(new Car(1, "Fiat", "Duplo", 1987, 35000, 730));
        }
    };

    @Test
    public void testGetAllCars() {

    }

    @Test
    public void testAddCar() throws Exception {
        //given
        String path = "maven project/buy-a-car/src/main/resources/";
        String filename = "database.yaml";
        Dealer dealerMock = Mockito.mock(Dealer.class);
        MapperFactory mapperFactoryMock = Mockito.mock(MapperFactory.class);
        ObjectMapper mapperMock = Mockito.mock(ObjectMapper.class);
        when(mapperFactoryMock.get()).thenReturn(mapperMock);
        when(dealerMock.getCars()).thenReturn(cars);
        when(mapperMock.readValue(ClassLoader.getSystemResourceAsStream(filename), Dealer.class)).thenReturn(dealerMock);
        //when(mapperMock.writeValue(ClassLoader.getSystemResourceAsStream(filename), dealerMock));
        //doNothing().when(mapperMock.writeValue(ClassLoader.getSystemResourceAsStream(filename), Dealer.class));
        //when
        Connection connection = new Connection(mapperFactoryMock);
        //then
        connection.addCar(cars.get(0));
    }

    @Test
    public void testGetCarById() throws IOException {
        //given
        String path = "maven project/buy-a-car/src/main/resources/";
        String filename = "database.yaml";
        Dealer dealerMock = Mockito.mock(Dealer.class);
        MapperFactory mapperFactoryMock = Mockito.mock(MapperFactory.class);
        ObjectMapper mapperMock = Mockito.mock(ObjectMapper.class);
        when(mapperFactoryMock.get()).thenReturn(mapperMock);
        when(dealerMock.getCars()).thenReturn(cars);
        when(mapperMock.readValue(ClassLoader.getSystemResourceAsStream(filename), Dealer.class)).thenReturn(dealerMock);
        //when
        Connection connection = new Connection(mapperFactoryMock);
        //then
        Car car = connection.getCarById(1);
        Assert.assertEquals(car.getBrand(), cars.get(1).getBrand());
    }

    @Test
    public void testRemoveCar() throws IOException {
        //given
        String path = "maven project/buy-a-car/src/main/resources/";
        String filename = "database.yaml";
        Dealer dealerMock = Mockito.mock(Dealer.class);
        MapperFactory mapperFactoryMock = Mockito.mock(MapperFactory.class);
        ObjectMapper mapperMock = Mockito.mock(ObjectMapper.class);
        when(mapperFactoryMock.get()).thenReturn(mapperMock);
        when(dealerMock.getCars()).thenReturn(cars);
        when(mapperMock.readValue(ClassLoader.getSystemResourceAsStream(filename), Dealer.class)).thenReturn(dealerMock);
        //when
        Connection connection = new Connection(mapperFactoryMock);
        //then
        connection.removeCar(1);
    }
}
