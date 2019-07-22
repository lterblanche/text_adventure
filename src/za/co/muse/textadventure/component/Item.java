package za.co.muse.textadventure.component;

import za.co.muse.textadventure.common.EnumInteraction;
import za.co.muse.textadventure.common.EnumInteractionStatus;

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


}
