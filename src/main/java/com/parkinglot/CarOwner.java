package com.parkinglot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.parkinglot.sortstrategies.StrategyComparator;

public class CarOwner {
	
	private List<ParkingLot> parkingLots;
	private StrategyComparator strategyComparator;
	
	public CarOwner(ParkingLot...parkingLots){
		this.parkingLots = Arrays.asList(parkingLots);
	}

	public void park(Car car) {
		//Collections.sort(this.parkingLots, strategyComparator);
		//parkingLots.get(0).park(car);
		parkingLots.stream().sorted(strategyComparator).findFirst().get().park(car);
		
	}
	
	public void sortStrategy(StrategyComparator strategyComparator){
		this.strategyComparator = strategyComparator;
	}
	
	

}
