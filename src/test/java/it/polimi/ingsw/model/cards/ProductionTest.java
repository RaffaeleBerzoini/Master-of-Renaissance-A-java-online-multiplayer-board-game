package it.polimi.ingsw.model.cards;

import it.polimi.ingsw.exceptions.InvalidArgumentException;
import it.polimi.ingsw.model.cards.Production;
import it.polimi.ingsw.model.cards.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductionTest {

    Value productionCost;
    Value productionOutput;
    Production production;

    @Before
    public void setUp() throws Exception {
        productionCost = new Value(null, null, 5);
        productionOutput = new Value(null, null, 5);
        production = new Production(productionCost, productionOutput);
    }

    @After
    public void tearDown() throws Exception {
        production = null;
    }

    @Test
    public void getProductionCost_returnCorrectValue() {
        assertEquals(productionCost, production.getProductionPower().get(0));
    }

    @Test
    public void getProductionOutput_returnCorrectValue() {
        assertEquals(productionOutput, production.getProductionPower().get(1));
    }

    @Test (expected = InvalidArgumentException.class)
    public void Production_constructor_InvalidArgumentException_ProductionCostNull() throws InvalidArgumentException {
        Production invalidProduction = new Production(null, productionOutput);
    }

    @Test (expected = InvalidArgumentException.class)
    public void Production_constructor_InvalidArgumentException_ProductionOutputNull() throws InvalidArgumentException {
        Production invalidProduction = new Production(productionCost, null);
    }
}