package com.parkinglot.sortstrategies;

import com.parkinglot.ParkingLot;

public class OrderByCapacity implements StrategyComparator{

	@Override
	public int compare(ParkingLot p1, ParkingLot p2) {
		if(p1.hasCapacity() == p2.hasCapacity())  
			return 0;  
		else if(p1.hasCapacity() < p2.hasCapacity())  
			return 1;  
		else  
			return -1; 
	}
}
