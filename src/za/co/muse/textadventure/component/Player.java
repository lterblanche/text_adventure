package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;

import java.util.ArrayList;

public class Player {
    private int posRow;
    private int posCol;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player() {

        System.out.println("Constructing player ...");
        System.out.println(("Player done."));
    }

    /**
     * Moves player to new position
     */

    void move(EnumDirection direction) {
        GameController controller = GameController.getInstance();
        Grid gameGrid = controller.getGrid();

        // First check to see if the move is doable
        if (gameGrid.canMoveInDirection(direction, getPosRow(), getPosCol())) {
            switch (direction) {
                case NORTH:
                    setCurrentPos(getPosRow() - 1, getPosCol());
                    break;

                case SOUTH:
                    setCurrentPos(getPosRow() + 1, getPosCol());
                    break;

                case EAST:
                    setCurrentPos(getPosRow(), getPosCol() + 1);
                    break;

                case WEST:
                    setCurrentPos(getPosRow(), getPosCol() - 1);
                    break;
            }
            System.out.println("Player moved to " + getPosRow() + ";" + getPosCol());
        } else {
            System.out.println("Can't go there idiot!");
        }
    }

    public String toString() {
        return ("My current position is " + getPosRow() + ";" + getPosCol());
    }

    int getPosRow() {
        return posRow;
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    int getPosCol() {
        return posCol;
    }

    public void setPosCol(int posCol) {
        this.posCol = posCol;
    }

    public void setCurrentPos(int row, int col) {
        if (GameController.getInstance().getGrid().isPositionInGrid(row, col)) {
            setPosCol(col);
            setPosRow(row);
        } else {
            System.out.println("Invalid player position!");
        }
    }


    /**
     * Adds given item to the Player's Inventory
     *
     * @param item Object to interact with
     * @return true if successful
     */
    public boolean addItemToInventory(Item item) {
        return this.inventory.add(item);
    }

    /**
     * Removes given item from Player's Inventory
     *
     * @param item Object to interact with
     * @return true if successful
     */
    public boolean removeItemFromInventory(Item item) {
        return this.inventory.remove(item);
    }

    /**
     * Returns true if this item exists in the inventory
     *
     * @param item Object to interact with
     * @return true if exists
     */
    public boolean hasItem(Item item) {
        return inventory.contains(item);
    }

    /**
     * Returns a text display of what the Player has on his person
     * @return String of items
     */
    public String listInventory() {
        StringBuilder stringBuilder = new StringBuilder();
        if (inventory.size() > 0) {
            stringBuilder.append("I have:");
            for (Item item : inventory) {
                stringBuilder.append("\n\t" + item.getName());
            }
        } else {
            stringBuilder.append("Sorry, my pockets are empty");
        }
        return stringBuilder.toString();
    }

    /**
     * Returns list of items on the player
     * @return
     */
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

}
