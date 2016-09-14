package com.parkinglot;

public interface ParkingLotObserver {
	public void notifyParkingFull();
	public void notifyParkingAvailable();
	public boolean isFullSignBoardSet();
}
