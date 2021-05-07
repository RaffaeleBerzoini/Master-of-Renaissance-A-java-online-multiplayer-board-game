package it.polimi.ingsw.messages.toServer;

import it.polimi.ingsw.common.ClientHandlerInterface;
import it.polimi.ingsw.common.ServerInterface;
import it.polimi.ingsw.controller.actions.BuyDevelopmentCardAction;
import it.polimi.ingsw.enumerations.Resource;
import it.polimi.ingsw.enumerations.ResourceStorageType;
import it.polimi.ingsw.utility.RemoveResources;

public class SelectStorageResponse implements MessageToServer{
    ResourceStorageType resourceStorageType;
    Resource resource;
    public SelectStorageResponse(Resource resource, ResourceStorageType resourceStorageType) {
        this.resourceStorageType=resourceStorageType;
    }

    @Override
    public void handleMessage(ServerInterface server, ClientHandlerInterface clientHandler) {
        RemoveResources.selectedStorage(resource, resourceStorageType);
    }
}
