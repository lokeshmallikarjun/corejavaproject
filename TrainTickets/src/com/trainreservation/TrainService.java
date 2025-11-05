package com.trainreservation;
import java.io.File;
import java.util.*;

public class TrainService {
    private static final String TRAIN_FILE = "data/trains.txt";
    private List<Train> trains = new ArrayList<>();

    public TrainService() {
        File file = new File(TRAIN_FILE);
        if (!file.exists() || file.length() == 0) {
            System.out.println("Creating default train data...");
            createDefaultTrains();
        }
        loadTrains();
    }

    private void createDefaultTrains() {
        List<String> defaultTrains = Arrays.asList(
            "1,Shatabdi Express,Bangalore,Chennai,100,100,750.0",
            "2,Rajdhani Express,Delhi,Mumbai,120,120,1500.0",
            "3,Duronto Express,Kolkata,Delhi,80,80,1300.0",
            "4,Garib Rath Express,Chennai,Hyderabad,90,90,600.0",
            "5,Intercity Express,Bangalore,Mysore,150,150,250.0",
            "6,Jan Shatabdi Express,Pune,Mumbai,180,180,350.0",
            "7,Karnataka Express,Delhi,Bangalore,200,200,2100.0",
            "8,Chennai Mail,Chennai,Coimbatore,140,140,400.0",
            "9,Goa Express,Pune,Goa,100,100,800.0",
            "10,Howrah Mail,Chennai,Kolkata,160,160,1700.0",
            "11,Nanda Devi Express,Dehradun,Delhi,120,120,500.0",
            "12,Sabarmati Express,Ahmedabad,Lucknow,110,110,950.0"
        );
        FileUtil.writeLines(TRAIN_FILE, defaultTrains);
    }

    private void loadTrains() {
        List<String> lines = FileUtil.readLines(TRAIN_FILE);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 7) {
                Train t = new Train(
                    Integer.parseInt(parts[0]),
                    parts[1], parts[2], parts[3],
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Double.parseDouble(parts[6])
                );
                trains.add(t);
            }
        }
    }

    public List<Train> getAllTrains() {
        return trains;
    }

    public Train getTrainById(int id) {
        for (Train t : trains) {
            if (t.getTrainId() == id) return t;
        }
        return null;
    }

    public void saveTrains() {
        List<String> lines = new ArrayList<>();
        for (Train t : trains) lines.add(t.toString());
        FileUtil.writeLines(TRAIN_FILE, lines);
    }
}
