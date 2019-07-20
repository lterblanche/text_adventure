package za.co.muse.textadventure.common;

import za.co.muse.textadventure.component.GameController;
import za.co.muse.textadventure.component.Item;
import za.co.muse.textadventure.component.Player;
import za.co.muse.textadventure.component.Space;

import javax.management.monitor.GaugeMonitor;


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
        Space s1 = new Space(1, 2, "Bedroom");
        // Add Items to Bedroom
        s1.addItemToInventory(new Item("Book", true));
        s1.addItemToInventory(new Item("Chair", false));
        s1.addItemToInventory(new Item("Bed", false));
        // Add exits
        s1.addExit(EnumDirection.EAST);

        //-----------------------------------------
        // HALLWAY (no items)
        //-----------------------------------------
        Space s2 = new Space(1, 3, "Hallway:");
        s2.addExit(EnumDirection.EAST);
        s2.addExit(EnumDirection.SOUTH);
        s2.addExit(EnumDirection.WEST);


        //-----------------------------------------
        // BEDROOM 2
        //-----------------------------------------
        Space s3 = new Space(1, 4, "Bedroom2");
        // Add Items to Bedroom
        s3.addItemToInventory(new Item("Chair", false));
        s3.addItemToInventory(new Item("Bed", false));
        s3.addItemToInventory(new Item("fireplace", false));
        s3.addItemToInventory(new Item("Closet", false));
        s3.addExit(EnumDirection.EAST);

        // .. do the rest here
        Space s4 = new Space(2,2,"HaalWay");
        //add items
        s4.addItemToInventory(new Item("Painting",false));

        Space s5 = new Space(2,3,"Hallway");
        Space s6 = new Space(2,4,"Hallway");

        Space s7 = new Space(3,2,"Storeroom");
        s7.addItemToInventory(new Item ("Ladder",true));
        s7.addItemToInventory(new Item ("Table",false));
        s7.addItemToInventory(new Item ("Chair",false));
        s7.addItemToInventory(new Item ("Lamp",false));

        Space s8 = new Space(3,3,"Hallway");

        Space s9 = new Space(3,4,"Study");

        s9.addItemToInventory(new Item("CHair",false));
        s9.addItemToInventory(new Item("Table",false));
        s9.addItemToInventory(new Item("Lockbox",false));
        s9.addItemToInventory(new Item("Letter",true));


//
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
        gameController.getGrid().addSpace(s1);
        gameController.getGrid().addSpace(s2);
        gameController.getGrid().addSpace(s3);

        gameController.getGrid().addSpace(s4);
        gameController.getGrid().addSpace(s5);
        gameController.getGrid().addSpace(s6);

        gameController.getGrid().addSpace(s7);
        gameController.getGrid().addSpace(s8);
        gameController.getGrid().addSpace(s9);
        // .. do the rest here

        while (!gameController.doAbortGame()) {
            gameController.getUserInput();
        }

        System.out.println("Thank you for playing.  Come again soon!");


    }

}
