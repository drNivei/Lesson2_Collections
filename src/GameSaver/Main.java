package GameSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        GameState gameState1 = (GameState) deserializeObject("MegaSave", 1);
        System.out.println(gameState1);

        serializeObject("MegaSave", gameState, 1);
        GameState gameState2 = (GameState) deserializeObject("MegaSave", 1);
        System.out.println(gameState2);
    }

    public static void serializeObject(String fileName, Object Person, Integer saveCell) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName + saveCell.toString() + ".save");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(Person);
            System.out.println("Object successfully serialized!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserializeObject(String fileName,Integer saveCell) {
        Object person = null;
        try (FileInputStream fileIn = new FileInputStream(fileName + saveCell.toString() + ".save");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            person = in.readObject();
            System.out.println("Deserialization completed!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


}
