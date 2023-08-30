package com.retail.ui;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;
import com.retail.shop.car.dto.CarDto;
import com.retail.shop.car.model.CarDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
// import org.powermock.api.mockito.PowerMockito;
// import org.powermock.core.classloader.annotations.PrepareForTest;
// import org.powermock.modules.junit4.PowerMockRunner;

import com.retail.business.CarBusinessImpl;
import com.retail.services.CarService;
import com.retail.shop.car.model.Car;

import junit.framework.TestCase;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest({ CarBusinessImpl.class })
public class UserInterfaceTest extends TestCase {

    public static List<Car> cars = new ArrayList<Car>() {
        {
            add(new Car(1, "Fiat", "Duplo", 1987, 35000, 730));
        }
    };

    // @BeforeEach
    // public void Setup() {

    // }

    @Test
    public void testShowMenuDeleteOption() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(3);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide id of the car you would like to remove:")).thenReturn(3);
        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).remove(3);
    }

    @Test
    public void testShowMenuShowOption() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readString("Please provide id of the car you would like to remove:")).thenReturn("Fiat");

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).getAllCarsCars();
    }

    @Test
    public void testShowMenuSearchOption() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(4);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readString("Please provide the name of the car:")).thenReturn("FiatDublo");
        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).getAllCarsCars();
    }

    @Test
    public void testShowMenuAddOption() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        CarDetails carDetails = new CarDetails();
        carDetails.setColor("Fait");
        carDetails.setVersion("Fait");
        carDetails.setHorsePower(300);
        carDetails.setGearbox(GearBoxEnum.Automatic);
        carDetails.setFuelType(FuelTypeEnum.PETROL);
        carDetails.setEngineCapacity(2.0f);
        Car car = new Car();
        car.setBrand("Fait");
        car.setModel("Fait");
        car.setPrice(100);
        car.setProductionYear(200);
        car.setCarKilometres(300);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(2);
        when(consoleInteractionMock.readString("Please provide brand name:")).thenReturn(car.getBrand());
        when(consoleInteractionMock.readString("Please provide model name:")).thenReturn(car.getModel());
        when(consoleInteractionMock.readNumber("Please provide price:")).thenReturn((int)car.getPrice());
        when(consoleInteractionMock.readNumber("Please provide production year:")).thenReturn(car.getProductionYear());
        when(consoleInteractionMock.readNumber("How many kilometers it has?")).thenReturn((int) car.getCarKilometres());
        when(consoleInteractionMock.readNumber("Please provide horsw power:")).thenReturn(100);
        when(consoleInteractionMock.readString("Please provide color:")).thenReturn("Fait");
        when(consoleInteractionMock.readString("Please provide version:")).thenReturn("Fait");
        when(consoleInteractionMock.readFloatNumber("Please provide engine capacity:")).thenReturn(2.0f);

        //details.setFuelType(readFuelType(consoleInteraction));
        //details.setGearbox(readGerBox(consoleInteraction));

        // CarBusinessImpl carBusinessImplMock =
        // PowerMockito.mock(CarBusinessImpl.class);
        // PowerMockito.whenNew(CarBusinessImpl.class).withNoArguments().thenReturn(carBusinessImplMock);

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).addCar(car);
    }
}
