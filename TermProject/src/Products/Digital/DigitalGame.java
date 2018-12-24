package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.GameInfo;
import Products.ProductInfo;

public class DigitalGame extends DigitalProduct {

    private GameInfo gameInfo;

    public DigitalGame(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
    
    @Override
    public ProductInfo getProductInfo() {
        return gameInfo;
    }
}
