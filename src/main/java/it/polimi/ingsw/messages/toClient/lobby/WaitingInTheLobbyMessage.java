package it.polimi.ingsw.messages.toClient.lobby;

import it.polimi.ingsw.common.ViewInterface;
import it.polimi.ingsw.messages.toClient.MessageToClient;

public class WaitingInTheLobbyMessage extends MessageToClient {

    public WaitingInTheLobbyMessage() {
        super(false);
    }

    @Override
    public void handleMessage(ViewInterface view) {
        view.displayWaitingInTheLobbyMessage();
    }

    public String toString(){
        return "sending waiting in the lobby message";
    }
}
