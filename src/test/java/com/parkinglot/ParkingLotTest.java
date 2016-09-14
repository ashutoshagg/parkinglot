package com.parkinglot;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParkingLotTest {
	
	@Test
	public void itShouldParkIfFreeSpaceAvailable(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		Car car = new Car("ASD123");
		
		//when
		parkingLot.park(car);
		
		//then
		assertTrue(parkingLot.isParked(car));		
	}
	
	@Test(expected = ParkingLot.DuplicateCarEntry.class)
	public void itShouldAvoidDuplicateCarParking(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		Car car = new Car("ASD234");
		parkingLot.park(car);
		
		//when
		parkingLot.park(car);
	}
	
	@Test(expected = ParkingLot.ParkingLotFull.class)
	public void itShouldParkOnlyIfFreeSapceAvailable(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		
		//when
		parkingLot.park(new Car("123"));
		parkingLot.park(new Car("456"));
		parkingLot.park(new Car("34"));
		parkingLot.park(new Car("45"));
	}
	
	@Test
	public void itShouldFreeSpaceOnUnparking(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		parkingLot.park(new Car("1"));
		parkingLot.park(new Car("2"));
		parkingLot.park(new Car("3"));
		
		//when
		parkingLot.unPark(new Car("1"));
		
		//then
		assertEquals(1, parkingLot.freeSpace());	
	}
	
	@Test(expected = ParkingLot.CarDoesNotExists.class)
	public void itShouldNotUnParkIfNotExists(){
		//given
		ParkingLot parkingLot = new ParkingLot(3);
		parkingLot.park(new Car("1"));
		
		//when
		parkingLot.unPark(new Car("2"));
	}
	
}
