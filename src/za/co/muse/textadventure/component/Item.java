package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumInteraction;
import za.co.muse.textadventure.common.EnumInteractionStatus;
import za.co.muse.textadventure.component.Item;
import za.co.muse.textadventure.component.ContainerItem;

import java.util.ArrayList;

public class Item {




        private String name;
        private boolean transferrable;
        //add the list odf possible actions that can be done with a Item
        private ArrayList<EnumInteraction> Interaction = new ArrayList<>();
        //
        private EnumInteractionStatus interactionStatus;

        public Item(String name, boolean isTransferrable) {
            this.setName(name);
            this.setTransferrable(isTransferrable);
        }

    private void move(String text) {
        String trimmedText = text.toLowerCase().trim();

        switch (trimmedText) {
            case "open":
                getInteraction().get(EnumInteraction.OPEN);
                break;

            case "close":
                getPlayer().move(EnumInteraction.CLOSE);
                break;

            case "read":
                getPlayer().move(EnumInteraction.READ);
                break;

            case "turn":
                getPlayer().move(EnumInteraction.TURN);
                break;
        }
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

        public ArrayList<EnumInteraction> getInteraction() {
            return Interaction;
        }

        public void setInteraction(ArrayList<EnumInteraction> interaction) {
            Interaction = interaction;
        }

        public EnumInteractionStatus getInteractionStatus() {
            return interactionStatus;
        }

        public void setInteractionStatus(EnumInteractionStatus interactionStatus) {
            this.interactionStatus = interactionStatus;
        }

        void Interact(EnumInteraction Interact) {
            switch (Interact) {

                //if the item can be opened
                case OPEN:
                    interactionStatus = EnumInteractionStatus.OPENED;
                    break;

                case CLOSE:
                    interactionStatus = EnumInteractionStatus.CLOSED;
                    break;

                case TURN:
                    interactionStatus = EnumInteractionStatus.TURNED;
                    break;

                case READ:
                    interactionStatus = EnumInteractionStatus.READ;
                    break;

                case CLIMB_UP:
                    interactionStatus = EnumInteractionStatus.CLIMBED_UP;
                    break;

                case CLIMB_DOWN:
                    interactionStatus = EnumInteractionStatus.CLIMBED_DOWN;
                    break;

            }

        }

    }






