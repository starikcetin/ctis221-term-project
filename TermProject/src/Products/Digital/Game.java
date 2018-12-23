package Products.Digital;

import Core.Product;
import ProductMetadata.GameInfo;

public class Game extends Product {

    private GameInfo gameInfo;

    public Game(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }
}
