package Products.Physical;

import Core.PhysicalProduct;
import ProductMetadata.GameInfo;

public class PhysicalGame extends PhysicalProduct {

    private GameInfo gameInfo;

    public PhysicalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
