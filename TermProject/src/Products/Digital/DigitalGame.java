package Products.Digital;

import Products.DigitalProduct;
import ProductInfos.GameInfo;

public class DigitalGame extends DigitalProduct {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
