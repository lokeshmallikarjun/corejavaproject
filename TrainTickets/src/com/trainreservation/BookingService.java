package com.trainreservation;
import java.util.*;

public class BookingService {
    private static final String BOOKING_FILE = "data/bookings.txt";
    private int bookingCounter = 1;

    public BookingService() {
        List<String> lines = FileUtil.readLines(BOOKING_FILE);
        if (!lines.isEmpty()) {
            String lastLine = lines.get(lines.size() - 1);
            bookingCounter = Integer.parseInt(lastLine.split(",")[0]) + 1;
        }
    }

    public void createBooking(String name, Train train, int seats) {
        if (seats > train.getAvailableSeats()) {
            System.out.println("Not enough seats available!");
            return;
        }

        double totalFare = train.getFare() * seats;
        Booking b = new Booking(bookingCounter++, name, train.getTrainId(), seats, totalFare);
        FileUtil.appendLine(BOOKING_FILE, b.toString());

        train.setAvailableSeats(train.getAvailableSeats() - seats);
        System.out.println("✅ Booking successful for " + name + "! Total Fare: ₹" + totalFare);
    }
}