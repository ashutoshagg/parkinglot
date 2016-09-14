package com.parkinglot;

public class Car {

	private String number;
	
	public Car(String number) {	
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (!(obj instanceof Car))
	        return false;
	    Car car = (Car) obj;
	    return number == null ? car.number == null : number.equals(car.number);
	}
	
	@Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

}
