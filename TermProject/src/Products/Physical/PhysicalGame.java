package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.GameInfo;
import Products.ProductInfo;
import Products.ProductType;

public class PhysicalGame extends PhysicalProduct {

    private GameInfo gameInfo;

    public PhysicalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return gameInfo;
    }

    @Override
    public ProductType getProductType() {
        return ProductType.Game;
    }
}
