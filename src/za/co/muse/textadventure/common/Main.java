package za.co.muse.textadventure.common;

import za.co.muse.textadventure.component.GameController;
import za.co.muse.textadventure.component.Item;
import za.co.muse.textadventure.component.Player;
import za.co.muse.textadventure.component.Space;


public class Main {

    public static void main(String[] args) {
        // Build GameController
        GameController gameController = GameController.getInstance();


        // Set grid
        gameController.getGrid().setNbCols(4);
        gameController.getGrid().setNbRows(4);

        //-----------------------------------------
        // BEDROOM 1
        //-----------------------------------------
        Space bedroomOne = new Space(1, 2, "Bedroom");
        // Add Items to Bedroom
        bedroomOne.addItemToInventory(new Item("Book", 1, 2, true));
        bedroomOne.addItemToInventory(new Item("Chair", 1, 2, false));
        bedroomOne.addItemToInventory(new Item("Bed", 1, 2, false));

        //-----------------------------------------
        // HALLWAY (no items)
        //-----------------------------------------
        Space hallwayOne = new Space(1, 3, "Hallway:");


        //-----------------------------------------
        // BEDROOM 2
        //-----------------------------------------
        Space bedroomTwo = new Space(1, 4, "Bedroom2");
        // Add Items to Bedroom
        bedroomTwo.addItemToInventory(new Item("Chair", 1, 4, false));
        bedroomTwo.addItemToInventory(new Item("Bed", 1, 4, false));
        bedroomTwo.addItemToInventory(new Item("fireplace", 1, 4, false));
        bedroomTwo.addItemToInventory(new Item("Closet", 1, 4, false));

        // .. do the rest here

//        Space b1 = new Space(2, 2, "Hallway");
//        Item b1Item1 = new Item("Painting", 2, 2, false);
//        //add items to b1
//        Space b2 = new Space(2, 3, "Hallway");
//        Space b3 = new Space(2, 4, "Hallway");
//
//        Space c1 = new Space(3, 2, "Store room");
//        Item c1Item1 = new Item("Ladder", 3, 2, true);
//        Item c1Item2 = new Item("Chair", 3, 2, false);
//        Item c1Item3 = new Item("Lamp", 3, 2, false);
//
//        Space c2 = new Space(3, 3, "Hallway");
//
//        Space c3 = new Space(3, 4, "Study");
//        Item c3Item1 = new Item("Lockbox", 3, 4, false);
//        Item c3Item2 = new Item("Chair", 3, 4, false);
//        Item c3Item3 = new Item("Note", 3, 4, true);
//        Item c3Item4 = new Item("Table", 3, 4, true);
//        Space d1 = new Space(4, 2, "Hallway");
//        Item d1Item1 = new Item("Door", 4, 2, false);
//        Item d1Item2 = new Item("Keyslot", 4, 2, false);
//
//        Space d2 = new Space(4, 3, "Hallway");
//        Item d2Item1 = new Item("Paiting", 3, 3, false);
//
//        Space d3 = new Space(4, 4, "Hallway");
//        Item d3Item1 = new Item("Chair", 4, 4, false);
//        Item d3Item2 = new Item("Chair", 4, 4, false);
//        Item d3Item3 = new Item("Table", 4, 4, false);
//        Space e = new Space(4, 1, "Vault");
//        Item eItem = new Item("Reward", 4, 1, true);

        // PLace the player in the main bedroom
        Player player = GameController.getInstance().getPlayer();
        player.setCurrentPos(1, 2);

        // Add the rooms/hallways to the game controller
        gameController.getGrid().addSpace(bedroomOne);
        gameController.getGrid().addSpace(bedroomTwo);
        gameController.getGrid().addSpace(hallwayOne);

        // .. do the rest here

        while (!gameController.doAbortGame()) {
            gameController.getUserInput();
        }

        System.out.println("Thank you for playing.  Come again soon!");


    }

}
