package com.retail.shop.car.model;

import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;

public class CarDetails {
    public int HorsePower;
    public String Color;
    public GearBoxEnum Gearbox;
    public double EngineCapacity;
    public String Version;
    public FuelTypeEnum FuelType;

    public CarDetails()
    {
        
    }

   public CarDetails(String color, String version, int horsePower, double engineCapacity, GearBoxEnum gearbox, FuelTypeEnum fuelType)
   {
       FuelType = fuelType;
       Color = color;
       Version = version;
       HorsePower = horsePower;
       EngineCapacity = engineCapacity;
       Gearbox = gearbox;
   }

public int getHorsePower() {
    return HorsePower;
}

public void setHorsePower(int horsePower) {
    HorsePower = horsePower;
}

public String getColor() {
    return Color;
}

public void setColor(String color) {
    Color = color;
}

public GearBoxEnum getGearbox() {
    return Gearbox;
}

public void setGearbox(GearBoxEnum gearbox) {
    Gearbox = gearbox;
}

public double getEngineCapacity() {
    return EngineCapacity;
}

public void setEngineCapacity(double engineCapacity) {
    EngineCapacity = engineCapacity;
}

public String getVersion() {
    return Version;
}

public void setVersion(String version) {
    Version = version;
}

public FuelTypeEnum getFuelType() {
    return FuelType;
}

public void setFuelType(FuelTypeEnum fuelType) {
    FuelType = fuelType;
}

@Override
public String toString() {
    return "CarDetails [HorsePower=" 
    + HorsePower + ", Color=" 
    + Color + ", Gearbox=" 
    + Gearbox + ", EngineCapacity="
    + EngineCapacity + ", Version=" 
    + Version + ", FuelType=" 
    + FuelType + "]";
}

}