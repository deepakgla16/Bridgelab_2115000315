import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";  // Contains ID, Name, Age
        String file2 = "students2.csv";  // Contains ID, Marks, Grade
        String outputFile = "merged_students.csv";

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentMap = new HashMap<>();

        // Read first CSV file (students1.csv)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0].trim();
                    studentMap.put(id, new String[]{data[1].trim(), data[2].trim(), "", ""});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file1 + ": " + e.getMessage());
            return;
        }

        // Read second CSV file (students2.csv)
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0].trim();
                    if (studentMap.containsKey(id)) {
                        studentMap.get(id)[2] = data[1].trim(); // Marks
                        studentMap.get(id)[3] = data[2].trim(); // Grade
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file2 + ": " + e.getMessage());
            return;
        }

        // Write merged data to a new CSV file (merged_students.csv)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n"); // Write header

            for (Map.Entry<String, String[]> entry : studentMap.entrySet()) {
                String id = entry.getKey();
                String[] details = entry.getValue();
                bw.write(String.format("%s,%s,%s,%s,%s\n", id, details[0], details[1], details[2], details[3]));
            }

            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing " + outputFile + ": " + e.getMessage());
        }
    }
}
