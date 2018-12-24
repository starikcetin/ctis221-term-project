package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.GameInfo;

public class PhysicalGame extends PhysicalProduct {

    private GameInfo gameInfo;

    public PhysicalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
