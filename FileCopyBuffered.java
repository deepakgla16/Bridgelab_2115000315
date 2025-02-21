import java.io.*;

public class FileCopyBuffered {
    public static void main(String[] args) {
        String sourceFile = "large_source.txt";  // Source file path
        String destinationFile = "large_destination.txt";  // Destination file path

        // Copy using unbuffered streams
        long startTime = System.nanoTime();
        copyUsingStreams(sourceFile, destinationFile, false);
        long endTime = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Copy using buffered streams
        startTime = System.nanoTime();
        copyUsingStreams(sourceFile, destinationFile, true);
        endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void copyUsingStreams(String sourceFile, String destinationFile, boolean useBuffer) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile);
             InputStream is = useBuffer ? new BufferedInputStream(fis) : fis;
             OutputStream os = useBuffer ? new BufferedOutputStream(fos) : fos) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            System.out.println((useBuffer ? "Buffered" : "Unbuffered") + " copy completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
