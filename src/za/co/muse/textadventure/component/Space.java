package za.co.muse.textadventure.component;

import java.util.ArrayList;
import java.util.List;
import za.co.muse.textadventure.component.Item;

public class Space {
    private int row_position = 0;
    private int col_position = 0;
    private String name;
    private ArrayList<Item> items = new ArrayList<>();



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

    public void addItem(Item aItem){
        boolean isValid = true;

        int aItemRow = aItem.getPositionRow();
        int aItemCol = aItem.getPositionCol();

        //Check to see if the space is valid
        if (isValid = true){
            items.add(aItem);

        }

        if (isValid){

        }
    }
}
