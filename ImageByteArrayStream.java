import java.io.*;

public class ImageByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";  // Change to the actual image file
        String outputImagePath = "output.jpg"; // Output file

        try {
            // Convert image to byte array
            byte[] imageData = imageToByteArray(inputImagePath);

            // Convert byte array back to image
            byteArrayToImage(imageData, outputImagePath);

            System.out.println("Image conversion successful. Check " + outputImagePath);
        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }

    // Method to convert an image file to a byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            return baos.toByteArray();
        }
    }

    // Method to convert a byte array back to an image file
    public static void byteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
