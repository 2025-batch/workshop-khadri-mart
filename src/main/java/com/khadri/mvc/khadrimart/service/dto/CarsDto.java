package com.khadri.mvc.khadrimart.service.dto;

public class CarsDto {
    private String carName;
    private int quantity;
    private String color;

    // Getters and Setters
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
