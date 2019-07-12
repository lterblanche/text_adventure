package za.co.muse.textadventure.common;

import za.co.muse.textadventure.component.GameController;
import za.co.muse.textadventure.component.Player;
import za.co.muse.textadventure.component.Space;
import za.co.muse.textadventure.component.Item;


public class Main {

    public static void main(String[] args) {
        // Build GameController
        GameController gameController = GameController.getInstance();


        // Set grid
        gameController.getGrid().setNbCols(4);
        gameController.getGrid().setNbRows(4);

        Space a1 = new Space(1, 2, "Bedroom");
        //add items to space a2
        Item a1Item1 = new Item("Book",1,2, true);
        Item a1Item2 = new Item("Chair",1,2, false);
        Item a1Item3 = new Item("Bed",1,2, false);

        Space a2 = new Space(1, 3, "Hallway:");
        //add items to space a3
        Space a3 = new Space(1, 4, "Bedroom2");
        Item a3Item1 = new Item("Chair",1,4, false);
        Item a3Item2 = new Item("Bed",1,4, false);
        Item a3Item3 = new Item("fireplace",1,4, false);
        Item a3Item4 = new Item("Closet",1,4, false);

        Space b1 = new Space(2, 2, "Hallway");
        Item b1Item1 = new Item("Painting",2,2, false);
        //add items to b1
        Space b2 = new Space(2, 3, "Hallway");
        Space b3 = new Space(2, 4, "Hallway");

        Space c1 = new Space(3, 2, "Store room");
        Item c1Item1 = new Item("Ladder",3,2, true);
        Item c1Item2 = new Item("Chair",3,2, false);
        Item c1Item3 = new Item("Lamp",3,2, false);

        Space c2 = new Space(3, 3, "Hallway");

        Space c3 = new Space(3, 4, "Study");
        Item c3Item1 = new Item("Lockbox",3,4,false);
        Item c3Item2 = new Item("Chair",3,4,false);
        Item c3Item3 = new Item("Note",3,4,true);
        Item c3Item4 = new Item("Table",3,4,true);
        Space d1 = new Space(4, 2, "Hallway");
        Item d1Item1 = new Item("Door",4,2,false);
        Item d1Item2 = new Item("Keyslot",4,2,false);

        Space d2 = new Space(4, 3, "Hallway");
        Item d2Item1 = new Item("Paiting",3,3,false);

        Space d3 = new Space(4, 4, "Hallway");
        Item d3Item1 = new Item("Chair",4,4,false);
        Item d3Item2 = new Item("Chair",4,4,false);
        Item d3Item3 = new Item("Table",4,4,false);
        Space e = new Space(4, 1, "Vault");
        Item eItem = new Item("Reward",4,1,true);
        Player player = GameController.getInstance().getPlayer();
        player.setCurrentPos(1, 2);


        gameController.getGrid().addSpace(a1);
        gameController.getSpace().addItem(a1Item1);
        gameController.getSpace().addItem(a1Item2);
        gameController.getSpace().addItem(a1Item3);

        gameController.getGrid().addSpace(a2);

        gameController.getGrid().addSpace(a3);
        gameController.getSpace().addItem(a3Item1);
        gameController.getSpace().addItem(a3Item2);
        gameController.getSpace().addItem(a3Item3);

        gameController.getGrid().addSpace(b1);
        gameController.getSpace().addItem(b1Item1);
        gameController.getGrid().addSpace(b2);
        gameController.getGrid().addSpace(b3);

        gameController.getGrid().addSpace(c1);
        gameController.getSpace().addItem(c1Item1);
        gameController.getSpace().addItem(c1Item2);
        gameController.getSpace().addItem(c1Item3);

        gameController.getGrid().addSpace(c2);
        gameController.getGrid().addSpace(c3);
        gameController.getSpace().addItem(c3Item1);
        gameController.getSpace().addItem(c3Item2);
        gameController.getSpace().addItem(c3Item3);
        gameController.getSpace().addItem(c3Item4);

        gameController.getGrid().addSpace(d1);
        gameController.getSpace().addItem(d1Item1);
        gameController.getSpace().addItem(d1Item2);
        gameController.getGrid().addSpace(d2);
        gameController.getSpace().addItem(d2Item1);

        gameController.getGrid().addSpace(d3);
        gameController.getSpace().addItem(d3Item1);
        gameController.getSpace().addItem(d3Item2);
        gameController.getSpace().addItem(d3Item3);
        gameController.getGrid().addSpace(e);
        gameController.getSpace().addItem(eItem);


        while (!gameController.doAbortGame()) {
            gameController.getUserInput();
        }

        System.out.println("Thank you for playing.  Come again soon!");


    }

}
