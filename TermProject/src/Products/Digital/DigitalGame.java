package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.GameInfo;
import Products.Interfaces.IGame;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalGame extends DigitalProduct implements IGame {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
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
