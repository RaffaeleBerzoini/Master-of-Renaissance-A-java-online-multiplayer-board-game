package it.polimi.ingsw.messages.toClient.game;

import it.polimi.ingsw.common.ViewInterface;
import it.polimi.ingsw.messages.toClient.MessageToClient;

/**
 * Message to ask in which slot the player wants to store the card
 */
public class SelectDevelopmentCardSlotRequest extends MessageToClient {

    private boolean firstSlotAvailable;
    private boolean secondSlotAvailable;
    private boolean thirdSlotAvailable;
    public SelectDevelopmentCardSlotRequest(boolean firstSlotAvailable,boolean secondSlotAvailable,boolean thirdSlotAvailable){
        super(true);
        this.firstSlotAvailable=firstSlotAvailable;
        this.secondSlotAvailable=secondSlotAvailable;
        this.thirdSlotAvailable=thirdSlotAvailable;
    }
    @Override
    public void handleMessage(ViewInterface view) {
        view.displaySelectDevelopmentCardSlotRequest(firstSlotAvailable,secondSlotAvailable,thirdSlotAvailable);
    }

    public String toString(){
        return "asking to choose a development card slot for the development card just bought";
    }
}
