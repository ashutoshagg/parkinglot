package com.parkinglot.sortstrategies;

import com.parkinglot.ParkingLot;

public class DefaultSort implements StrategyComparator {

    @Override
    public int compare(ParkingLot o1, ParkingLot o2) {
        if(o1.freeSpace() > 0)
            return 1;
        return -1;
    }
}
