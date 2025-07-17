package GameSaver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Inventory implements Serializable {
    Map<String, Integer> inventory = new HashMap<>();

    Inventory(){
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
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
