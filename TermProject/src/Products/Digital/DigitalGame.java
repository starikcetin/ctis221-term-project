package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.GameInfo;

public class DigitalGame extends DigitalProduct {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
