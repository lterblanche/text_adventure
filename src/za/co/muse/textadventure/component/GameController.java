package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumDirection;

import java.util.Scanner;

public class GameController {
    private static GameController self;
    /**
     * Used to collect user input
     */
    private Scanner inputScanner;
    private Grid grid;
    private Player player;
    private Space space;
    private boolean abortGame = false;



    /**
     * Private constructor
     */
    private GameController() {
        System.out.println("Constructing game controller...");
        grid = new Grid(4, 4);
        player = new Player();
        space = new Space();
        System.out.println(getPlayer());
        inputScanner = new Scanner(System.in);
        System.out.println("Game controller done.");
    }

    /**
     * Singleton
     *
     * @return GameController
     */
    public static GameController getInstance() {
        if (self == null) {
            self = new GameController();
        }
        return self;
    }

    /**
     * Navigates through the grid
     */

    private void move(String text) {
        String trimmedText = text.toLowerCase().trim();

        switch (trimmedText) {
            case "north":
                player.move(EnumDirection.NORTH);
                break;

            case "south":
                player.move(EnumDirection.SOUTH);
                break;

            case "west":
                player.move(EnumDirection.WEST);
                break;

            case "east":
                player.move(EnumDirection.EAST);
                break;
        }
    }

    /**
     * Shows the Player where he/she is, what is visible and what can be interacted with.
     */
    private void look() {
        // What room are we in?
        Space userSpace = grid.getSpace(player.getPosRow(), player.getPosCol());
        System.out.println("You are now in the " + userSpace.getName() + ".");
        System.out.println("Your position is [" + player.getPosRow() + "; " + player.getPosCol() + "]");
    }


    public Grid getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }


    public boolean doAbortGame() {
        return abortGame;
    }

    public void getUserInput() {
        System.out.println("What do you want to do? (use `move ...`, `look`, or `end`:");
        String userInput = inputScanner.nextLine();
        // MOVE
        if (userInput.toLowerCase().contains("move ")) {
            self.move(userInput.substring(5));
        }
        // LOOK
        if (userInput.toLowerCase().contains("look")) {
            self.look();
            space.listItems();

        }
        // END
        if (userInput.toLowerCase().contains("end")) {
            abortGame = true;
        }
        if (userInput.toLowerCase().contains("Inventory")){
            player.listInventory();
        }
    }
    ///
    ///
    ///
    ///


}
