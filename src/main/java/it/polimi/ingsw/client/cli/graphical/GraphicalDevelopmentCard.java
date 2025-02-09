package it.polimi.ingsw.client.cli.graphical;

import it.polimi.ingsw.common.LightCard;
import it.polimi.ingsw.enumerations.Level;

/**
 * Class to represents a development Card
 */
public class GraphicalDevelopmentCard extends GraphicalCard{


    public GraphicalDevelopmentCard(LightCard ldc, String nickname) {
        super(ldc, nickname);
    }

    @Override
    public void drawCard(){
        reset();
        drawEdges(this.height, this.width);
        drawFlag();
        drawCost(1, lightCard.getCost());
        drawID();
        drawVictoryPoints();
        drawProductionCost();
        drawProductionOutput();
    }

    /**
     * Draw the flag (type and colour) of the development Card
     */
    private void drawFlag() {
        Colour flagColor = getColor(lightCard.getFlagColor());
        int level = getLevel(lightCard);
        for (int j = 0; j <= level; j++){
            symbols[1+j][2] = '\u25CF';
            colours[1+j][2] = flagColor;
        }
    }

    private int getLevel(LightCard ldc){
        return Level.valueOf(ldc.getFlagLevel()).getValue();
    }


}
