import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change this to your desired file path

        // Try-with-resources to ensure automatic resource closure
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Write each input as a new line
            }

            System.out.println("User input successfully written to " + filePath);

        } catch (IOException e) {
            System.err.println("Error handling the file: " + e.getMessage());
        }
    }
}
