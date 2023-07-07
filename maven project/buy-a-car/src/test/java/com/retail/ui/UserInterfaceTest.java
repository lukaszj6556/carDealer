package com.retail.ui;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.retail.business.CarBusinessImpl;
import com.retail.services.CarService;
import com.retail.shop.car.model.Car;

import junit.framework.TestCase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CarBusinessImpl.class })
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
    public void ShowMenuDeleteOptionTest() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(3);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide id of the car you would like to remove:")).thenReturn(3);
        CarBusinessImpl carBusinessImplMock = PowerMockito.mock(CarBusinessImpl.class);
        PowerMockito.whenNew(CarBusinessImpl.class).withNoArguments().thenReturn(carBusinessImplMock);

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).remove(3);
    }

    @Test
    public void ShowMenuAddOptionTest() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide id of the car you would like to remove:")).thenReturn(3);
        CarBusinessImpl carBusinessImplMock = PowerMockito.mock(CarBusinessImpl.class);
        PowerMockito.whenNew(CarBusinessImpl.class).withNoArguments().thenReturn(carBusinessImplMock);
        doNothing().when(UserInterface.class);

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        // verify(, times(1)).remove(3);
    }

    @Test
    public void ShowMenuSearchOptionTest() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(4);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        CarBusinessImpl carBusinessImplMock = PowerMockito.mock(CarBusinessImpl.class);
        PowerMockito.whenNew(CarBusinessImpl.class).withNoArguments().thenReturn(carBusinessImplMock);

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        verify(carServiceMock, times(1)).getAllCarsCars();
    }

    @Test
    public void ShowMenuShowOptionTest() throws Exception {
        // given
        CarService carServiceMock = Mockito.mock(CarService.class);
        when(carServiceMock.getAllCarsCars()).thenReturn(cars);
        ConsoleInteraction consoleInteractionMock = Mockito.mock(ConsoleInteraction.class);
        when(consoleInteractionMock.readNumber("Please choose option.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide how the cars should be sorted.")).thenReturn(1);
        when(consoleInteractionMock.readNumber("Please provide id of the car you would like to remove:")).thenReturn(3);
        CarBusinessImpl carBusinessImplMock = PowerMockito.mock(CarBusinessImpl.class);
        PowerMockito.whenNew(CarBusinessImpl.class).withNoArguments().thenReturn(carBusinessImplMock);

        // when
        UserInterface.showMenu(carServiceMock, consoleInteractionMock);

        // then
        // verify(carServiceMock, times(1)).remove(3);
    }
}
