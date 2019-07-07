package za.co.muse.textadventure.common;

import za.co.muse.textadventure.component.GameController;
import za.co.muse.textadventure.component.Player;
import za.co.muse.textadventure.component.Space;


public class Main {

    public static void main(String[] args) {
        // Build GameController
        GameController gameController = GameController.getInstance();


        // Set grid
        gameController.getGrid().setNbCols(4);
        gameController.getGrid().setNbRows(4);

        Space a1 = new Space(1, 2, "Bedroom");
        Space a2 = new Space(1, 3, "Hallway:");
        Space a3 = new Space(1, 4, "Outside");

        Space b1 = new Space(2, 2, "Hallway");
        Space b2 = new Space(2, 3, "Hallway");
        Space b3 = new Space(2, 4, "Hallway");

        Space c1 = new Space(3, 2, "Store room");
        Space c2 = new Space(3, 3, "Hallway");
        Space c3 = new Space(3, 4, "Study");

        Space d1 = new Space(4, 2, "Hallway");
        Space d2 = new Space(4, 3, "Hallway");
        Space d3 = new Space(4, 4, "Hallway");

        Space e = new Space(4, 1, "Vault");


        Player player = GameController.getInstance().getPlayer();
        player.setCurrentPos(1, 2);


        gameController.getGrid().addSpace(a1);
        gameController.getGrid().addSpace(a2);
        gameController.getGrid().addSpace(a3);
        gameController.getGrid().addSpace(b1);
        gameController.getGrid().addSpace(b2);
        gameController.getGrid().addSpace(b3);
        gameController.getGrid().addSpace(c1);
        gameController.getGrid().addSpace(c2);
        gameController.getGrid().addSpace(c3);
        gameController.getGrid().addSpace(d1);
        gameController.getGrid().addSpace(d2);
        gameController.getGrid().addSpace(d3);
        gameController.getGrid().addSpace(e);


        while (!gameController.doAbortGame()) {
            gameController.getUserInput();
        }

        System.out.println("Thank you for playing.  Come again soon!");


    }

}
