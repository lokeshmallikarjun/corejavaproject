package com.trainreservation;
import java.io.*;
import java.util.*;

public class FileUtil {
    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return lines;
    }

    public static void writeLines(String filePath, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) bw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error writing file: " + filePath);
        }
    }

    public static void appendLine(String filePath, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error appending file: " + filePath);
        }
    }
}