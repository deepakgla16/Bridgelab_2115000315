import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static final String SECRET_KEY = "MySecretKey12345"; // Must be 16 chars for AES-128

    public static void main(String[] args) {
        String csvFile = "employees_encrypted.csv";  // Encrypted CSV file
        String decryptedFile = "employees_decrypted.csv"; // Decrypted CSV output

        // Sample employee data
        List<String[]> employees = Arrays.asList(
            new String[]{"101", "Alice Johnson", "HR", "55000", "alice@example.com"},
            new String[]{"102", "Bob Smith", "IT", "70000", "bob@example.com"},
            new String[]{"103", "Charlie Brown", "Finance", "65000", "charlie@example.com"}
        );

        // Encrypt and write data to CSV
        encryptAndWriteCSV(csvFile, employees);

        // Read and decrypt data from CSV
        decryptAndReadCSV(csvFile, decryptedFile);
    }

    // Encrypt and write CSV
    public static void encryptAndWriteCSV(String filePath, List<String[]> employees) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Department,Salary,Email\n"); // Header

            for (String[] emp : employees) {
                String encryptedSalary = encrypt(emp[3]);
                String encryptedEmail = encrypt(emp[4]);

                bw.write(emp[0] + "," + emp[1] + "," + emp[2] + "," + encryptedSalary + "," + encryptedEmail + "\n");
            }

            System.out.println("CSV file encrypted and saved as: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Read, decrypt, and write decrypted CSV
    public static void decryptAndReadCSV(String encryptedFile, String decryptedFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(encryptedFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(decryptedFile))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Copy header row
                    bw.write(line + "\n");
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length == 5) {
                    String decryptedSalary = decrypt(data[3]);
                    String decryptedEmail = decrypt(data[4]);

                    bw.write(data[0] + "," + data[1] + "," + data[2] + "," + decryptedSalary + "," + decryptedEmail + "\n");
                }
            }

            System.out.println("CSV file decrypted and saved as: " + decryptedFile);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // AES Encryption
    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    // AES Decryption
    public static String decrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
    }
}
