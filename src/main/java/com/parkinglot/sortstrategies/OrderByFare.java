package com.parkinglot.sortstrategies;

import com.parkinglot.ParkingLot;

public class OrderByFare  implements StrategyComparator{

	@Override
	public int compare(ParkingLot p1, ParkingLot p2) {
		if(p1.hasFare() == p2.hasFare())  
			return 0;  
		else if(p1.hasFare() > p2.hasFare())  
			return 1;  
		else  
			return -1; 
	}
}
