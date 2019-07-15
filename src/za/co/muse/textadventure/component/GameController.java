package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;

import java.util.Scanner;

public class GameController {
    private static GameController self;
    private Scanner inputScanner;
    private Grid grid;
    private Player player;
    private Space space;
    private Item item;
    private boolean abortGame = false;



    /**
     * Private constructor
     */
    private GameController() {
        System.out.println("Constructing game controller...");
        setGrid(new Grid(4, 4));
        setPlayer(new Player());
        setSpace(new Space());
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

    /**
     * Shows the Player where he/she is, what is visible and what can be interacted with.
     */
    private void look() {
        // What room are we in?
        Space userSpace = getGrid().getSpace(getPlayer().getPosRow(), getPlayer().getPosCol());
        System.out.println("You are now in the " + userSpace.getName() + ".");
        System.out.println("Your position is [" + getPlayer().getPosRow() + "; " + getPlayer().getPosCol() + "]");
    }


    public Grid getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }


    public boolean doAbortGame() {
        return isAbortGame();
    }

    public void getUserInput() {
        System.out.println("What do you want to do? (use `move ...`, `look`, `Inventory`, `Pickup` or `end`:");
        String userInput = getInputScanner().nextLine();
        // MOVE
        if (userInput.toLowerCase().contains("move ")) {
            getSelf().move(userInput.substring(5));
        }
        // LOOK
        if (userInput.toLowerCase().contains("look")) {
            getSelf().look();
            getSpace().listItems();

        }
        // END
        if (userInput.toLowerCase().contains("end")) {
            setAbortGame(true);
        }
        if (userInput.toLowerCase().contains("Inventory")){
            getPlayer().listInventory();

        }
        if (userInput.toLowerCase().contains("Pickup")){
            System.out.println("Which item do you want to add to your inventory?");
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

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public boolean isAbortGame() {
        return abortGame;
    }

    public void setAbortGame(boolean abortGame) {
        this.abortGame = abortGame;
    }
    ///
    ///
    ///
    ///
    //add item into inventory
    public void addItem(Item inven){
        if (inven.isCanTransferOwnership() == true){
            player.addInventory(inven);
        }
    }

}
