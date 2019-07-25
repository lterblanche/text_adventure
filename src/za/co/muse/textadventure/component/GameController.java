package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;
import za.co.muse.textadventure.common.EnumInteraction;
import za.co.muse.textadventure.common.EnumInteraction;
import za.co.muse.textadventure.common.EnumInteractionStatus;
import za.co.muse.textadventure.component.Item;
import za.co.muse.textadventure.component.ContainerItem;

import java.util.Scanner;

public class GameController {
    private static GameController self;
    private Scanner inputScanner;
    private Grid grid;
    private Player player;
    private Item item;
    private boolean abortGame = false;


    /**
     * Private constructor
     */
    private GameController() {
        System.out.println("Constructing game controller...");
        setGrid(new Grid(4, 4));
        setPlayer(new Player());
        System.out.println(getPlayer());
        setInputScanner(new Scanner(System.in));
        System.out.println("Game controller done.");
    }

    /**
     * Singleton
     *
     * @return GameController
     */
    public static GameController getInstance() {
        if (getSelf() == null) {
            setSelf(new GameController());
        }
        return getSelf();
    }

    public static GameController getSelf() {
        return self;
    }

    public static void setSelf(GameController self) {
        GameController.self = self;
    }

    /**
     * Navigates through the grid
     */

    private void move(String text) {
        String trimmedText = text.toLowerCase().trim();

        switch (trimmedText) {
            case "north":
                getPlayer().move(EnumDirection.NORTH);
                break;

            case "south":
                getPlayer().move(EnumDirection.SOUTH);
                break;

            case "west":
                getPlayer().move(EnumDirection.WEST);
                break;

            case "east":
                getPlayer().move(EnumDirection.EAST);
                break;
        }
    }




    //Interact with a Item e.g. Open/Close/Read
    private void interact(String text){
        String trimmedText = text.toLowerCase().trim();

        switch (trimmedText) {
            case "open":
                getItem().Interact(EnumInteraction.OPEN);
                break;

            case "close":
                getItem().Interact(EnumInteraction.CLOSE);
                break;

            case "turn":
                getItem().Interact(EnumInteraction.TURN);
                break;

            case "read":
                getItem().Interact(EnumInteraction.READ);
                break;

            case "climbed up":
                getItem().Interact(EnumInteraction.CLIMB_UP);
                break;

            case "climbed down":
                getItem().Interact(EnumInteraction.CLIMB_DOWN);
                break;
        }


    }




    public Grid getGrid() {
        return grid;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean doAbortGame() {
        return isAbortGame();
    }

    public void getUserInput() {
        System.out.println("What do you want to do? (use `move ...`, `look`, `inventory`, `pickup`, `drop` or `end`:");
        String userInput = getInputScanner().nextLine();
        // MOVE
        if (userInput.toLowerCase().contains("move ")) {
            getSelf().move(userInput.substring(5));
        }

        // LOOK
        if (userInput.toLowerCase().contains("look")) {
            // Look where we are
            System.out.println(getSurroundings());
            // What's in the room
            System.out.println(getSpaceWherePlayerIs().listInventory());
            // What do I have on me?
            System.out.println(getPlayer().listInventory());
        }
        // END
        if (userInput.toLowerCase().contains("end")) {
            setAbortGame(true);
        }
        // LIST INVENTORY
        if (userInput.toLowerCase().contains("inventory")) {
            getPlayer().listInventory();
        }
        // INTERACT
        if (userInput.toLowerCase().contains("pickup")) {
            if (performPickup(userInput.substring(6))) {
                System.out.println("Okay");
            } else {
                System.out.println("Can't do that");
            }
        }
        if (userInput.toLowerCase().contains("drop")) {
            if (performDrop(userInput.substring(4))) {
                System.out.println("Item Dropped");

            } else {
                System.out.println("Could not Drop item here");
            }
        }

    }

    /**
     * Used to collect user input
     */
    public Scanner getInputScanner() {
        return inputScanner;
    }

    public void setInputScanner(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public boolean isAbortGame() {
        return abortGame;
    }

    public void setAbortGame(boolean abortGame) {
        this.abortGame = abortGame;
    }

    /**
     * Returns a String, showing the Player where he/she is,
     * what is visible and what can be interacted with.
     */
    private String getSurroundings() {
        // What room are we in?
        StringBuilder stringBuilder = new StringBuilder();
        Space userSpace = getGrid().getSpace(getPlayer().getPosRow(), getPlayer().getPosCol());
        stringBuilder.append("You are now in the " + userSpace.getName() + ".");
        stringBuilder.append("Your position is [" + getPlayer().getPosRow() + "; " + getPlayer().getPosCol() + "]");

        return stringBuilder.toString();
    }

    /**
     * Easy way to get the space where the player is now.
     *
     * @return
     */
    public Space getSpaceWherePlayerIs() {
        return getGrid().getSpace(getPlayer().getPosRow(), getPlayer().getPosCol());
    }

    /**
     * Picks up item
     *
     * @param itemToPickUp
     * @return
     */
    private boolean performPickup(String itemToPickUp) {
        // Find item in room with this name (case-insensitive)
        for (Item item : getSpaceWherePlayerIs().getInventory()) {
            String itemName = item.getName().trim();
            if (itemToPickUp.trim().compareToIgnoreCase(itemName) == 0) {
                // Stem 1, can we interact with this item?
                if (item.isTransferrable()) {
                    // Step 1, remove the item from the room
                    getSpaceWherePlayerIs().removeItemFromInventory(item);
                    // Step 2, add the item to the player
                    getPlayer().addItemToInventory(item);
                    // Done, we're happy
                    return true;
                }
            }
        }
        // We probably didn't get the item.
        return false;
    }

    private boolean performDrop(String itemToDrop) {
        //Drop item in room the player is currently in
        for (Item item : getPlayer().getInventory()) {
            String itemName = item.getName().trim();
            if (itemToDrop.trim().compareToIgnoreCase(itemName) == 0) {
                //Remove Item from player inventory
                getPlayer().removeItemFromInventory(item);
                System.out.println("Removing " + item.getName() + " from player inventory.");
                //Place item in room
                Space space = getSpaceWherePlayerIs();
                space.addItemToInventory(item);
                System.out.println("Dropping " + item.getName() + " in " + space.getName());
                //Done we're happy
                return true;
            }
        }
        return true;
    }


}
