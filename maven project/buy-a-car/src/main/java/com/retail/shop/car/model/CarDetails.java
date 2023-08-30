package com.retail.shop.car.model;

import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;

public class CarDetails {
    private int horsePower;
    private String color;
    private GearBoxEnum gearbox;
    private float engineCapacity;
    private String version;
    private FuelTypeEnum fuelType;

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public GearBoxEnum getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearBoxEnum gearbox) {
        this.gearbox = gearbox;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "CarDetails [HorsePower=" 
        + horsePower + ", Color=" 
        + color + ", Gearbox=" 
        + gearbox + ", EngineCapacity="
        + engineCapacity + ", Version=" 
        + version + ", FuelType=" 
        + fuelType + "]";
    }

    public double getkWh() {
        return this.horsePower * 0.74;
    }
}