package com.retail.shop.car.dto;

import com.retail.shop.car.constants.FuelTypeEnum;
import com.retail.shop.car.constants.GearBoxEnum;

public class CarDto {
    private String name;
    private double engine;
    private int productionYear;
    private long carKilometres;
    private double price;
    private int horsePower;
    private String color;
    private GearBoxEnum gearbox;
    private double engineCapacity;
    private String version;
    private FuelTypeEnum fuelType;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getEngine() {
        return engine;
    }
    public void setEngine(double engine) {
        this.engine = engine;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    public long getCarKilometres() {
        return carKilometres;
    }
    public void setCarKilometres(long carKilometres) {
        this.carKilometres = carKilometres;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
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
    public double getEngineCapacity() {
        return engineCapacity;
    }
    public void setEngineCapacity(double engineCapacity) {
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
        return "CarDto [name=" + name + ", engine=" + engine + ", productionYear=" + productionYear + ", carKilometres="
                + carKilometres + ", price=" + price + ", horsePower=" + horsePower + ", color=" + color + ", gearbox="
                + gearbox + ", engineCapacity=" + engineCapacity + ", version=" + version + ", fuelType=" + fuelType
                + "]";
    }
}
