package GameSaver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XORCipher {

    public static void encryptDecrypt(String inputFilePath, String outputFilePath, byte[] key) {
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {

            int byteRead;
            int keyIndex = 0;

            while ((byteRead = fis.read()) != -1) {
                // XOR the byte with the key byte
                byte encryptedByte = (byte) (byteRead ^ key[keyIndex]);
                fos.write(encryptedByte);

                // Move to the next key byte, wrapping around if necessary
                keyIndex = (keyIndex + 1) % key.length;
            }

        } catch (IOException e) {
            System.err.println("Error during file operation: " + e.getMessage());
        }
    }
}