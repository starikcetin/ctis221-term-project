package Products.Digital;

import Core.DigitalProduct;
import ProductInfos.GameInfo;

public class DigitalGame extends DigitalProduct {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
