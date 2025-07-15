package GameSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static GameSaver.XORCipher.decrypt;
import static GameSaver.XORCipher.encrypt;

public class Main {
    public static void main(String[] args) {
        //player stats
        String player_Name = "Gustav";
        int lvl = 75;
        long points = 100500;
        List<String> achievements = new ArrayList<>();
            achievements.add("Big guy");
            achievements.add("Nightmare of the pigs");
        long played = 123458;
        Inventory inventory = new Inventory();
            inventory.addItem("Bad Copper Sword", 1);
            inventory.addItem("Health potion", 2);
            inventory.addItem("Gold coin", 100);

        GameState gameState = new GameState(player_Name, lvl, points, achievements, played, inventory);

        serializeObject("MegaSave", gameState, 1);
        encryptSave("MegaSave", 1);
        // GameState gameState1 = (GameState) deserializeObject("MegaSave", 1);
        // System.out.println(gameState1);

        //serializeObject("MegaSave", gameState, 2);
        //GameState gameState2 = (GameState) deserializeObject("MegaSave", 2);
        //System.out.println(gameState2);
    }

    public static void serializeObject(String fileName, Object Person, Integer saveCell) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + saveCell.toString() + ".save", false);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(Person);
            System.out.println("Object successfully serialized!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamCorruptedException e) {
            System.out.println("Файл поврежден! Загрузка невозможна.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void encryptSave(String fileName, Integer saveCell) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + saveCell.toString() + ".save", false);
             FileInputStream fileIn = new FileInputStream(fileName + saveCell.toString() + ".save")) {

            String key = "KEY1";
            byte[] str = fileIn.readAllBytes();
            byte[] keyBytes = key.getBytes();
            byte[] encr = encrypt(str, keyBytes);
            fileOut.write(encr);
            System.out.println("Encrypted!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamCorruptedException e){
            System.out.println("Файл поврежден! Загрузка невозможна.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Object deserializeObject(String fileName,Integer saveCell) {
        Object person = null;
        try (FileOutputStream fileOut = new FileOutputStream(fileName + saveCell.toString() + ".save");
             FileInputStream fileIn = new FileInputStream(fileName + saveCell.toString() + ".save");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            String key = "KEY1";
            byte[] str = fileIn.readAllBytes();
            byte[] keyBytes = key.getBytes();
            byte[] decr = decrypt(str, keyBytes);
            fileOut.write(decr);
            System.out.println("Decrypted!");

            person = in.readObject();
            System.out.println("Deserialization completed!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamCorruptedException e){
            System.out.println("Файл поврежден! Загрузка невозможна.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


}
