package Products.Digital;

import Core.DigitalProduct;
import ProductMetadata.GameInfo;

public class DigitalGame extends DigitalProduct {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
