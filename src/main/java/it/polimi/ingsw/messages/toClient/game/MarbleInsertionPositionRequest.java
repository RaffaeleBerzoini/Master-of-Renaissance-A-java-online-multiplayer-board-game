package it.polimi.ingsw.messages.toClient.game;

import it.polimi.ingsw.common.ViewInterface;
import it.polimi.ingsw.messages.toClient.MessageToClient;

public class MarbleInsertionPositionRequest extends MessageToClient {

    public MarbleInsertionPositionRequest(){
        super(true);
    }
    @Override
    public void handleMessage(ViewInterface view) {
        view.displayMarbleInsertionPositionRequest();
    }

    public String toString(){
        return "asking marble insertion position";
    }
}
