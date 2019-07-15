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
            System.out.println("Player moved to "+ getPosRow()+";"+ getPosCol());
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

    int getPosCol() {
        return posCol;
    }

    public void setCurrentPos(int row, int col){
        if (GameController.getInstance().getGrid().isPositionInGrid(row, col)) {
            setPosCol(col);
            setPosRow(row);
        } else {
            System.out.println("Invalid player position!");
        }
    }
    //add item to the inventory
    public  void addInventory(Item aItem){

            getInventory().add(aItem);
            System.out.println("Item added to inventory");

    }
    //list all items currenty in the inventory
    public void listInventory(){
        for (int i = 0; i< getInventory().size(); i++){
            System.out.println(getInventory().get(i));
        }
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    public void setPosCol(int posCol) {
        this.posCol = posCol;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
