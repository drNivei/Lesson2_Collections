package GameSaver;

public class XORCipher {

    public static byte[] encrypt(byte[] message, byte[] key) {
        byte[] cipherText = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            cipherText[i] = (byte) (message[i] ^ key[i % key.length]);
        }
        return cipherText;
    }

    public static byte[] decrypt(byte[] cipherText, byte[] key) {
        return encrypt(cipherText, key); // Шифрование и дешифрование одинаковы для XOR
    }
}
