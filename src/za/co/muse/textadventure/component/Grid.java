package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;

import java.util.ArrayList;
import java.util.List;


public class Grid {
    private int nbRows;
    private int nbCols;
    private List<Space> blocks = new ArrayList<>();



    public Grid(int nbRows, int nbCols) {
        System.out.println("Constructing " + nbRows + " x " + nbCols + " grid...");
        this.setNbRows(nbRows);
        this.setNbCols(nbCols);
        System.out.println("Grid done.");

    }

    public void addSpace(Space aSpace) {
        boolean isValid = true;

        int aSpaceRow = aSpace.getRow_position();
        int aSpaceCol = aSpace.getCol_position();

        // Check to see if this is a valid position
        if (!isPositionInGrid(aSpaceRow, aSpaceCol)) {
            isValid = false;
        }

        // Check if there's a space already
        if (isValid && getSpace(aSpaceRow, aSpaceCol) == null) {
            blocks.add(aSpace);
            System.out.println("Space '" + aSpace.getName() + "' added to grid.");
        } else {
            System.out.println("Can't place a Space here");
        }
    }



    /**
     * Returns the space in this position
     * @param aRow
     * @param aCol
     * @return
     */
    Space getSpace(int aRow, int aCol) {
        for (Space block : getBlocks()) {
            if (block.getCol_position() == aCol && block.getRow_position() == aRow) {
                return block;
            }
        }

        return null;
    }


    public void removeSpace(Space aSpace) {
        getBlocks().remove(aSpace);
    }

    public void removeSpace(int aRow, int aCol) {
        for (Space block : getBlocks()) {
            if (block.getCol_position() == aCol && block.getRow_position() == aRow) {
                getBlocks().remove(block);
                break;
            }
        }
    }

    /**
     * This routine determines if a player can move from the current position in the given direction
     *
     * @param direction  NORTH/EAST/...
     * @param currentRow
     * @param currentCol
     * @return
     */
    public boolean canMoveInDirection(EnumDirection direction, int currentRow, int currentCol) {
        // Set new position same as current
        int newRow = currentRow;
        int newCol = currentCol;

        // Update new position according to direction
        switch (direction) {

            case NORTH:
                newRow--;
                break;

            case SOUTH:
                newRow++;
                break;

            case EAST:
                newCol++;
                break;

            case WEST:
                newCol--;
                break;
        }

        // Step through blocks.  If one exists in new position, returns true
        for (Space block : getBlocks()) {
            if (block.getCol_position() == newCol && block.getRow_position() == newRow) {
                return true;
            }
        }

        return false;
    }


    /**
     * Can only add player and spaces in valid grid positions
     *
     * @param aRow Row to evaluate
     * @param aCol Col to evaluate
     * @return
     */
    public boolean isPositionInGrid(int aRow, int aCol) {

        if (aRow < 1 || aRow > nbRows) {
            return false;
        }

        if (aCol < 1 || aCol > nbCols) {
            return false;
        }
        return true;
    }

    public int getNbRows() {
        return nbRows;
    }

    public void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }

    public int getNbCols() {
        return nbCols;
    }

    public void setNbCols(int nbCols) {
        this.nbCols = nbCols;
    }

    public List<Space> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Space> blocks) {
        this.blocks = blocks;
    }
}