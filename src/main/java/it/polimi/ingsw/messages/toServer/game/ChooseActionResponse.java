package it.polimi.ingsw.messages.toServer.game;

import it.polimi.ingsw.common.ClientHandlerInterface;
import it.polimi.ingsw.common.ServerInterface;
import it.polimi.ingsw.messages.toServer.MessageToServer;

/**
 * Message to notify the server with the action chosen
 */
public class ChooseActionResponse implements MessageToServer {
    private int actionChosen;
    public ChooseActionResponse(int actionChosen) {
        this.actionChosen=actionChosen;
    }

    public int getActionChosen() {
        return actionChosen;
    }

    @Override
    public void handleMessage(ServerInterface server, ClientHandlerInterface clientHandler) {
        clientHandler.getController().handleMessage(this,clientHandler);
    }

    public String toString(){
        return "received the action chosen";
    }

}
