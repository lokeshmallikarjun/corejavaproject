package com.trainreservation;

public class Train {
    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    public Train(int trainId, String trainName, String source, String destination,
                 int totalSeats, int availableSeats, double fare) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    public int getTrainId() { return trainId; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getFare() { return fare; }

    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    @Override
    public String toString() {
        return trainId + "," + trainName + "," + source + "," + destination + "," +
                totalSeats + "," + availableSeats + "," + fare;
    }
}