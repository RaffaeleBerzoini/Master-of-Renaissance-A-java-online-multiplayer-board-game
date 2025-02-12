package it.polimi.ingsw.model.depot;

import it.polimi.ingsw.enumerations.Resource;
import it.polimi.ingsw.exceptions.InsufficientQuantityException;
import it.polimi.ingsw.exceptions.InsufficientSpaceException;
import it.polimi.ingsw.exceptions.InvalidArgumentException;
import it.polimi.ingsw.exceptions.InvalidDepotException;
import org.junit.Test;

import static org.junit.Assert.*;

    public class StrongboxDepotTest {
        StrongboxDepot depot;

        @Test
        public void testAddRemoveResources() throws InvalidDepotException, InvalidArgumentException, InsufficientQuantityException, InsufficientSpaceException {
            depot = new StrongboxDepot(Resource.COIN);
            depot.addResources(2);
            assertEquals(depot.getResourceType(), Resource.COIN);
            assertEquals(depot.getResourceQuantity(), 2);
            assertEquals(depot.toString(), "Depot: resource=COIN, quantity=2");
            depot.removeResources(2);
            assertEquals(depot.getResourceQuantity(), 0);
            assertEquals(depot.getResourceType(), Resource.COIN);
        }

        @Test (expected = InsufficientQuantityException.class)
        public void testExtraRemove() throws InvalidArgumentException, InsufficientQuantityException {
            depot = new StrongboxDepot(Resource.COIN);
            depot.removeResources(2);
        }

        @Test (expected = InvalidArgumentException.class)
        public void testInvalidRemove() throws InvalidArgumentException, InsufficientQuantityException {
            depot = new StrongboxDepot(Resource.COIN);
            depot.removeResources(-2);
        }

        @Test (expected = InvalidArgumentException.class)
        public void testInvalidAdd() throws InvalidArgumentException, InsufficientQuantityException, InvalidDepotException, InsufficientSpaceException {
            depot = new StrongboxDepot(Resource.COIN);
            depot.addResources(-2);
        }

        @Test (expected = InvalidDepotException.class)
        public void testInvalidDepot() throws InvalidDepotException, InvalidArgumentException, InsufficientSpaceException {
            depot = new StrongboxDepot();
            depot.addResources(3);
        }


    }





