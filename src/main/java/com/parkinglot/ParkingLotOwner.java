package com.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver{
	
	private boolean isFullSignBoardSet;

	@Override
	public void notifyParkingFull() {
		this.isFullSignBoardSet = true;		
	}

	@Override
	public void notifyParkingAvailable() {
		this.isFullSignBoardSet = false;
	}

	@Override
	public boolean isFullSignBoardSet() {
		return isFullSignBoardSet;
	}

}
