package com.parkinglot;

import org.junit.Test;

import com.parkinglot.sortstrategies.OrderByAvailableSpacePercentage;
import com.parkinglot.sortstrategies.OrderByCapacity;
import com.parkinglot.sortstrategies.OrderByFreeSpace;

import static org.junit.Assert.*;

public class AttendantTest {

	@Test
	public void itShouldParkCarsInMultipleSlots(){
		//given
		ParkingLotObserver owner = new ParkingLotOwner();
		ParkingLot parkingLot = new ParkingLot(2);
		parkingLot.registerObserver(owner);
		ParkingLot parkingLot2 = new ParkingLot(3);
		parkingLot2.registerObserver(owner);
		
		ParkingAttendant attendant = new ParkingAttendant(parkingLot, parkingLot2);
		
		//when
		attendant.park(new Car("1"));
		attendant.park(new Car("2"));
		attendant.park(new Car("3"));
		
		//then
		assertEquals(2, parkingLot2.freeSpace());
	}
	
	@Test
	public void itShouldUnParkCarsFromMultipleSlots(){
		//given
		ParkingLotObserver owner = new ParkingLotOwner();
		ParkingLot parkingLot = new ParkingLot(2);
		parkingLot.registerObserver(owner);
		ParkingLot parkingLot2 = new ParkingLot(3);
		parkingLot2.registerObserver(owner);
		
		ParkingAttendant attendant = new ParkingAttendant(parkingLot, parkingLot2);
		attendant.park(new Car("1"));
		attendant.park(new Car("2"));
		attendant.park(new Car("3"));
		
		//when
		attendant.unPark(new Car("2"));
		
		//then
		assertEquals(1, parkingLot.freeSpace());
	}
	
	@Test
	public void itShouldDirectCarsToLotHavingMaxFreeSpace(){
		//given
		ParkingLotObserver owner = new ParkingLotOwner();
		ParkingLot parkingLot = new ParkingLot(5);
		parkingLot.registerObserver(owner);
		ParkingLot parkingLot2 = new ParkingLot(6);
		parkingLot2.registerObserver(owner);

		ParkingAttendant attendant = new ParkingAttendant(parkingLot, parkingLot2);
		attendant.sortStrategy(new OrderByFreeSpace());
		attendant.park(new Car("1"));
		attendant.park(new Car("2"));		

		//when		
		attendant.park(new Car("3"));

		//then
		assertEquals(4, parkingLot.freeSpace());
	}
	
	@Test
	public void itShouldDirectCarsToLotHavingMaxCapacity(){
		//given
		ParkingLotObserver owner = new ParkingLotOwner();
		ParkingLot parkingLot = new ParkingLot(6);
		parkingLot.registerObserver(owner);
		ParkingLot parkingLot2 = new ParkingLot(5);
		parkingLot2.registerObserver(owner);

		ParkingAttendant attendant = new ParkingAttendant(parkingLot, parkingLot2);
		attendant.sortStrategy(new OrderByCapacity());
		attendant.park(new Car("1"));
		attendant.park(new Car("2"));		

		//when		
		attendant.park(new Car("3"));

		//then
		assertEquals(3, parkingLot.freeSpace());
	}
	
	@Test
	public void itShouldDirectCarsToLotHavingMaxPercentageFreeSpace(){
		//given
		ParkingLotObserver owner = new ParkingLotOwner();
		ParkingLot parkingLot = new ParkingLot(6, 20);
		parkingLot.registerObserver(owner);
		ParkingLot parkingLot2 = new ParkingLot(5, 25);
		parkingLot2.registerObserver(owner);

		ParkingAttendant attendant = new ParkingAttendant(parkingLot, parkingLot2);
		attendant.sortStrategy(new OrderByAvailableSpacePercentage());
		attendant.park(new Car("1"));
		attendant.park(new Car("2"));		

		//when		
		attendant.park(new Car("3"));

		//then
		assertEquals(4, parkingLot2.freeSpace());
	}
	
	
}
