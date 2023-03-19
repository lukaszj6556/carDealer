package com.retail.shop.car.model;

import java.util.List;

public class Dealer {
   public List<Car> Cars;
   public String Name;

public String getName() {
    return Name;
}

public void setName(String name) {
    Name = name;
}

@Override
public String toString() {
    String cars = "";
    for (Car car : Cars) {
        cars += car.toString();
    }
    return "Dealer [Cars=" + cars + ", Name=" + Name + "]";
}

public List<Car> getCars() {
    return Cars;
}

public void setCars(List<Car> cars) {
    Cars = cars;
}


}