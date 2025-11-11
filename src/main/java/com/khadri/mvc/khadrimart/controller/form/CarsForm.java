package com.khadri.mvc.khadrimart.controller.form;

public class CarsForm {
    private String carName;
    private int quantity;
    private String color;
    private String userName;

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
    public String getUserName() 
    { 
    	return userName; 
    	}
    public void setUserName(String userName) 
    { 
    	this.userName = userName; 
    	}
}

