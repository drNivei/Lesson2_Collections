package GameSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static GameSaver.XORCipher.encryptDecrypt;

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
        //Standart Flow
        serializeObject("MegaSave", gameState, 1);
        GameState gameState1 = (GameState) deserializeObject("MegaSave", 1);
        System.out.println(gameState1 + "\n");

        //Multiple cell saving.
        serializeObject("MegaSave", gameState, 2);
        System.out.println("\n");

        //Corrupted file
        GameState gameState2 = (GameState) deserializeObject("MegaSave", 3);
        System.out.println(gameState2 + "\n");

    }

    public static void serializeObject(String fileName, Object Person, Integer saveCell) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + saveCell.toString() + ".save", false);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(Person);
            System.out.println("Save file successfully created!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamCorruptedException e) {
            System.out.println("Файл поврежден! Сохранение невозможно.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            String key = "KEY123";
            byte[] keyBytes = key.getBytes();
            encryptDecrypt(fileName + saveCell.toString() + ".save", fileName + saveCell.toString() + ".encr", keyBytes);
            System.out.println("Save file successfully encrypted!");
            File deleteMe = new File(fileName + saveCell.toString() + ".save");
            deleteMe.delete();

    }


    public static Object deserializeObject(String fileName,Integer saveCell) {
        Object person = null;

        String key = "KEY123";
        byte[] keyBytes = key.getBytes();
        encryptDecrypt(fileName + saveCell.toString() + ".encr", fileName + saveCell.toString() + ".save", keyBytes);
        System.out.println("Save file successfully decrypted!");
        File deleteMe = new File(fileName + saveCell.toString() + ".encr");
        deleteMe.delete();

        try (FileInputStream fileIn = new FileInputStream(fileName + saveCell.toString() + ".save");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

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
