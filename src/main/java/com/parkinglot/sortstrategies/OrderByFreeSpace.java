package com.parkinglot.sortstrategies;

import com.parkinglot.ParkingLot;

public class OrderByFreeSpace implements StrategyComparator{

	@Override
	public int compare(ParkingLot p1, ParkingLot p2) {
		if(p1.freeSpace() == p2.freeSpace())  
			return 0;  
		else if(p1.freeSpace() < p2.freeSpace())  
			return 1;  
		else  
			return -1; 
	}

}
