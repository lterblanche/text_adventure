package za.co.muse.textadventure.component;

import java.util.ArrayList;

public class ContainerItem extends Item {
    private ArrayList<Item> CItems = new ArrayList<>();

    public ContainerItem(String name, boolean isTransferrable) {
        super(name, isTransferrable);

    }


    //place a Item inside the container
    public void addItem(Item item){
            CItems.add(item);

    }
    //remove a item from the container
    public void removeItem(Item item,boolean isTransferrable){
        if (isTransferrable == true){
            CItems.remove(item);
        }
    }
    //what is the item name
    public void Itemname(Item item){

    }
    //list all items inside the container
    public void listItems(ArrayList<Item> itemList){
        for (int i=0;i < itemList.size();i++){
            System.out.println(itemList.get(i).getName());
        }
    }




}
