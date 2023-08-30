package com.retail.shop.car;

import com.retail.services.CarServiceImpl;
import com.retail.services.CarService;
import com.retail.ui.ConsoleInteraction;
import com.retail.ui.ConsoleInteractionImpl;
import com.retail.ui.ScannerWrapperImpl;
import com.retail.ui.UserInterface;

public class App {
    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();
        ScannerWrapperImpl wrapper = new ScannerWrapperImpl();
        ConsoleInteraction consoleInteraction = new ConsoleInteractionImpl(wrapper);

        UserInterface.showMenu(carService, consoleInteraction);
    }
}
