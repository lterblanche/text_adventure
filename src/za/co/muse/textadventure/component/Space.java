package za.co.muse.textadventure.component;

import java.util.ArrayList;
import java.util.HashSet;

import za.co.muse.textadventure.common.EnumDirection;

public class Space {
    private int row_position = 0;
    private int col_position = 0;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();
    private HashSet<EnumDirection> exists = new HashSet<>();



    public Space() {
        this(1, 1, "Unknown");
    }

    public Space(int row_position, int col_position, String name) {
        this.setRow_position(row_position);
        this.setCol_position(col_position);
        this.name = name;
    }


    public int getRow_position() {
        return row_position;
    }

    public void setRow_position(int row_position) {
        this.row_position = row_position;
    }

    public int getCol_position() {
        return col_position;
    }

    public void setCol_position(int col_position) {
        this.col_position = col_position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds given item to the Player's Inventory
     * @param item Object to interact with
     * @return true if successful
     */
    public boolean addItemToInventory(Item item){
        return this.inventory.add(item);
    }

    /**
     * Removes given item from Player's Inventory
     * @param item Object to interact with
     * @return true if successful
     */
    public boolean removeItemFromInventory(Item item){
        return this.inventory.remove(item);
    }

    /**
     * Returns true if this item exists in the inventory
     * @param item Object to interact with
     * @return true if exists
     */
    public boolean hasItem(Item item){
        return inventory.contains(item);
    }

    /**
     * Returns a text display of what the Space contains
     * @return String of items
     */
    public String listInventory() {
        StringBuilder stringBuilder = new StringBuilder();
        if (inventory.size() > 0) {
            stringBuilder.append("I see:");
            for (Item item : inventory) {
                stringBuilder.append("\n\t" + item.getName());
            }
        } else {
            stringBuilder.append("There are no items to see/interact with here.");
        }
        return stringBuilder.toString();
    }

    /**
     * Returns list of items in this space
     * @return
     */
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public HashSet<EnumDirection> getPassages() { return this.exists; }

    public void addExit(EnumDirection direction){
        exists.add(direction);
    }

    public boolean canExit(EnumDirection direction){
        return exists.contains(direction);
    }
}
