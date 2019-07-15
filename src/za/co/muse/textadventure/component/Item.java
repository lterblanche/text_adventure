package za.co.muse.textadventure.component;

public class Item {
    // private int positionRow;
    // private int positionCol;
    private String name;
    private boolean transferrable;

    public Item(String name, int positionRow, int positionCol, boolean isTransferrable) {
        this.setName(name);
        this.setTransferrable(isTransferrable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTransferrable() {
        return transferrable;
    }

    public void setTransferrable(boolean transferrable) {
        this.transferrable = transferrable;
    }
}
