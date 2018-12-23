package Products.Physical;

import Core.PhysicalProduct;
import ProductInfos.GameInfo;

public class PhysicalGame extends PhysicalProduct {

    private GameInfo gameInfo;

    public PhysicalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
