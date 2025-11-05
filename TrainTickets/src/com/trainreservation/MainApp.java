package com.trainreservation;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainService trainService = new TrainService();
        BookingService bookingService = new BookingService();

        while (true) {
            System.out.println("\n===== TRAIN RESERVATION SYSTEM =====");
            System.out.println("1. View All Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Train t : trainService.getAllTrains()) {
                        System.out.printf("%d | %s | %s -> %s | Fare: %.2f | Seats: %d\n",
                                t.getTrainId(), t.getTrainName(), t.getSource(),
                                t.getDestination(), t.getFare(), t.getAvailableSeats());
                    }
                    break;

                case 2:
                    System.out.print("Enter Train ID: ");
                    int id = sc.nextInt();
                    Train train = trainService.getTrainById(id);
                    if (train == null) {
                        System.out.println("Train not found!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter number of seats: ");
                    int seats = sc.nextInt();

                    bookingService.createBooking(name, train, seats);
                    trainService.saveTrains();
                    break;

                case 3:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}