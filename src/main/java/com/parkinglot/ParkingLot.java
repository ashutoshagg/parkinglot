package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	private int freeSpace;
	private int capacity, fare;
	private List<Car> slots;
	private ParkingLotObserver observer;
	
	public ParkingLot(int space) {
		this.freeSpace = space;
		this.capacity = space;
		slots = new ArrayList<>();
	}

	public ParkingLot(int space, int price) {
		this.freeSpace = space;
		this.capacity = space;
		this.fare = price;
		slots = new ArrayList<>();
	}

	public void park(Car car) {		
		validateParking(car);
		slots.add(car);
		freeSpace--;
		notifyObservers();
	}
	
	public void unPark(Car car) {	
		if(!isParked(car))
			throw new CarDoesNotExists();
		slots.remove(car);
		freeSpace++;
		notifyObservers();
	}

	private void validateParking(Car car) {
		if(isParked(car))
			throw new DuplicateCarEntry();
		if(isSlotEmpty())
			throw new ParkingLotFull();
	}

	public boolean isSlotEmpty() {
		return freeSpace == 0;
	}
	
	public int freeSpace(){
		return freeSpace;
	}

	public boolean isParked(Car car) {
		return slots.contains(car);
	}
	
	public void registerObserver(ParkingLotObserver observer) {
		this.observer = observer;
	}
	
	private void notifyObservers(){
		if(isObserverRegistered()){
			if(isSlotEmpty())
				this.observer.notifyParkingFull();
			else
				this.observer.notifyParkingAvailable();
		}
	}
	
	private boolean isObserverRegistered() {
		return this.observer != null ;	
	}
	
	public int hasCapacity() {
		return capacity;
	}
	
	public int hasFare(){
		return fare;
	}
	
	public double getPercentageSpaceAvailable(){
		if(hasCapacity() > 0)
			return (freeSpace/hasCapacity())*100;
		return 0;
		
	}

	public class DuplicateCarEntry extends RuntimeException{
	}
	
	public class ParkingLotFull extends RuntimeException{
	}

	public class CarDoesNotExists extends RuntimeException{

	}


}
