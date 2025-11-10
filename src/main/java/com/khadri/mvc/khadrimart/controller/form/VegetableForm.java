package com.khadri.mvc.khadrimart.controller.form;

public class VegetableForm {
	private String vegname;
    private double quantity;

    public String getVegname() 
    { 
    	return vegname; 
    	}
    public void setVegname(String vegname) 
    { 
    	this.vegname = vegname; 
    	}

    public double getQuantity() 
    { 
    	return quantity; 
    }
    public void setQuantity(double quantity)
    { 
    	this.quantity = quantity; 
    	}
}
