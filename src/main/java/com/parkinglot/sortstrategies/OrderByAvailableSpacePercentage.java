package com.parkinglot.sortstrategies;

import com.parkinglot.ParkingLot;

public class OrderByAvailableSpacePercentage implements StrategyComparator{

	@Override
	public int compare(ParkingLot p1, ParkingLot p2) {
		if(p1.getPercentageSpaceAvailable() == p2.getPercentageSpaceAvailable())  
			return 0;  
		else if(p1.getPercentageSpaceAvailable() < p2.getPercentageSpaceAvailable())  
			return 1;  
		else  
			return -1; 
	}
	
}
