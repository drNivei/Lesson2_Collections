package GameSaver;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<String, Integer> inventory = new HashMap<>();

    Inventory(){

    }

    public void addItem(String name, int amount){
        inventory.put(name, amount);
    }

    public void remove_All_Items(String name){
        inventory.remove(name);
    }

    public void change_Item_amount(String name, int amount){
        inventory.replace(name, amount);
    }
}
