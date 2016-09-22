package com.parkinglot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.parkinglot.sortstrategies.DefaultSort;
import com.parkinglot.sortstrategies.StrategyComparator;

public class ParkingAttendant {
	
	private List<ParkingLot> parkingLots;
	private StrategyComparator strategyComparator;

	public ParkingAttendant(ParkingLot...parkingLots) {
		this.parkingLots = Arrays.asList(parkingLots);
		strategyComparator = new DefaultSort();
	}
	
	public void sortStrategy(StrategyComparator strategyComparator){
		this.strategyComparator = strategyComparator;
	}
	
	public void park(Car car){
		parkingLots.stream().sorted(strategyComparator).filter(e -> e.freeSpace() > 0).findFirst().get().park(car);
	}
	
	public void unPark(Car car){
		parkingLots.stream().filter(e -> e.isParked(car)).findFirst().get().unPark(car);
	}
}



//	public void park(Car car) {		
//		Collections.sort(parkingLots, strategyComparator);
//		for(ParkingLot parkingLot : parkingLots){
//			if(parkingLot.freeSpace() > 0){
//				parkingLot.park(car);
//				break;
//			}
//		}
//	}

//	public void unPark(Car car) {
//		for(ParkingLot parkingLot : parkingLots){
//			if(parkingLot.isParked(car)){
//				parkingLot.unPark(car);
//				break;
//			}				
//		}		
//	}


