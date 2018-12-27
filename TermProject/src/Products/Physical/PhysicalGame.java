package Products.Physical;

import Products.Infos.BookInfo;
import Products.PhysicalProduct;
import Products.Infos.GameInfo;
import Products.Interfaces.IGame;
import Products.ProductInfo;
import Products.ProductType;

public class PhysicalGame extends PhysicalProduct implements IGame {

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
    
    @Override
    public void updateProductInfo(ProductInfo newProductInfo) {
        gameInfo = (GameInfo) newProductInfo;
    }
}
