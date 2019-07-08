package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;

public class Player {
    private int posRow;
    private int posCol;

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
        if (gameGrid.canMoveInDirection(direction, posRow, posCol)) {
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
        return ("My current position is " + posRow + ";" + posCol);
    }

    int getPosRow() {
        return posRow;
    }

    int getPosCol() {
        return posCol;
    }

    public void setCurrentPos(int row, int col){
        if (GameController.getInstance().getGrid().isPositionInGrid(row, col)) {
            posCol = col;
            posRow = row;
        } else {
            System.out.println("Invalid player position!");
        }
    }

}
