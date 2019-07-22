package za.co.muse.textadventure.component;

import java.util.ArrayList;
import za.co.muse.textadventure.component.Item;

public class ContainerItem {
    private ArrayList<Item> CItem = new ArrayList<>();
    //place a Item into the Container
    public void addItem(Item item) {
        CItem.add(item);
    }
    //remove a Item from the container
    public void removeItem(Item item) {
        CItem.remove(item);
    }
//list all the Items in the ContainerItem
    public void getItem(Item item) {
        for (int i=0;i<CItem.size();i++){
            System.out.println(CItem.get(i).getName());
        }
    }


}
