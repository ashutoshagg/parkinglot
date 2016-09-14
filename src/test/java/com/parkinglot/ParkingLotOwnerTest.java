package com.parkinglot;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParkingLotOwnerTest {
	
	@Test
	public void itShouldPutFullSignBoardOnParkingFull(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		ParkingLotOwner owner = new ParkingLotOwner();
		parkingLot.registerObserver(owner);
		
		//when
		parkingLot.park(new Car("1"));
		parkingLot.park(new Car("2"));
		parkingLot.park(new Car("3"));
		
		//then
		assertTrue(owner.isFullSignBoardSet());
	}
	
	@Test
	public void itShouldTakeInFullSignBooardOnParkingAvailable(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);	
		ParkingLotOwner owner = new ParkingLotOwner();
		parkingLot.registerObserver(owner);

		parkingLot.park(new Car("1"));
		parkingLot.park(new Car("2"));
		parkingLot.park(new Car("3"));
		
		//when
		parkingLot.unPark(new Car("1"));
		
		//then
		assertFalse(owner.isFullSignBoardSet());
	}
}
