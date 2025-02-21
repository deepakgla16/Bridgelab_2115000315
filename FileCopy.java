import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Source file name
        String destinationFile = "destination.txt";  // Destination file name

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Attempt to open the source file
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            // Create input and output streams
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            // Buffer to hold file data
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from source and write to destination
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        } finally {
            try {
                // Close resources
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file streams: " + e.getMessage());
            }
        }
    }
}
