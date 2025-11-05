package com.trainreservation;

public class Booking {
    private int bookingId;
    private String passengerName;
    private int trainId;
    private int seatsBooked;
    private double totalFare;

    public Booking(int bookingId, String passengerName, int trainId, int seatsBooked, double totalFare) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.trainId = trainId;
        this.seatsBooked = seatsBooked;
        this.totalFare = totalFare;
    }

    public int getBookingId() { return bookingId; }

    @Override
    public String toString() {
        return bookingId + "," + passengerName + "," + trainId + "," + seatsBooked + "," + totalFare;
    }
}