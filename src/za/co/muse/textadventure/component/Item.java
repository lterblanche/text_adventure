package za.co.muse.textadventure.component;

public class Item {
    private int positionRow;
    private int positionCol;
    private String name;
    private boolean canTransferOwnership;

    public Item(String name,int positionRow, int positionCol,boolean canTransferOwnership){
        this.setName(name);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
        this.setCanTransferOwnership(canTransferOwnership);

    }


    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanTransferOwnership() {
        return canTransferOwnership;
    }

    public void setCanTransferOwnership(boolean canTransferOwnership) {
        this.canTransferOwnership = canTransferOwnership;
    }
}
