package com.retail.shop.car.model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int productionYear;
    private long carKilometres;
    private double price;
    private CarDetails carDetails;

    public Car() {
    }

    public Car(int id, String brand, String model, int productionYear, long carKilometres, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.carKilometres = carKilometres;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public CarDetails getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(CarDetails carDetails) {
        this.carDetails = carDetails;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", productionYear=" + productionYear + ", carKilometres="
                + carKilometres + ", price=" + price + ", carDetails=" + carDetails.toString() + "]";
    }

}