package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.GameInfo;
import Products.ProductInfo;

public class PhysicalGame extends PhysicalProduct {

    private GameInfo gameInfo;

    public PhysicalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
        
    @Override
    public ProductInfo getProductInfo() {
        return gameInfo;
    }
}
