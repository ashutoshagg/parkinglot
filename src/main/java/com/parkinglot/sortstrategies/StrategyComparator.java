package com.parkinglot.sortstrategies;

import java.util.Comparator;

import com.parkinglot.ParkingLot;

public interface StrategyComparator extends Comparator<ParkingLot>{	

	public abstract int compare(ParkingLot p1, ParkingLot p2);

}
