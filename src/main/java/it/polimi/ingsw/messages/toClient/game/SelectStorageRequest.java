package it.polimi.ingsw.messages.toClient.game;

import it.polimi.ingsw.common.ViewInterface;
import it.polimi.ingsw.enumerations.Resource;
import it.polimi.ingsw.messages.toClient.MessageToClient;

/**
 * Message to ask from which storage getting a resource
 */
public class SelectStorageRequest extends MessageToClient {
Resource resource;
boolean isInWarehouse;
boolean isInStrongbox;
boolean isInLeaderDepot;
    public SelectStorageRequest(Resource resource, boolean isInWarehouse,boolean isInStrongbox, boolean isInLeaderDepot) {
        super(true);
        this.resource=resource;
        this.isInWarehouse=isInWarehouse;
        this.isInStrongbox=isInStrongbox;
        this.isInLeaderDepot=isInLeaderDepot;
    }

    @Override
    public void handleMessage(ViewInterface view) {
        view.displaySelectStorageRequest(resource, isInWarehouse, isInStrongbox, isInLeaderDepot);
    }

    public String toString(){
        return "asking to choose a storage type to remove resources";
    }
}
