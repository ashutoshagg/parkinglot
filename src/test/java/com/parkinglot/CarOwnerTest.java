package com.parkinglot;

import org.junit.Test;

import com.parkinglot.sortstrategies.OrderByFare;

import static org.junit.Assert.*;

public class CarOwnerTest {
	
	@Test
	public void itShouldParkInLotHavingCheapFare(){
		//given
		ParkingLot parkingLot = new ParkingLot(5, 25);
		ParkingLot parkingLot2 = new ParkingLot(6, 20);
				
		CarOwner owner = new CarOwner(parkingLot, parkingLot2);
		owner.sortStrategy(new OrderByFare());
		
		//when
		owner.park(new Car("1"));
		
		//then
		assertEquals(5, parkingLot2.freeSpace());
	}
	
	
}
