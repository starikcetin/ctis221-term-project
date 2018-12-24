package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.MusicInfo;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalMusic extends DigitalProduct {

    private MusicInfo musicInfo;

    public DigitalMusic(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return musicInfo;
    }

    @Override
    public ProductType getProductType() {
        return ProductType.Music;
    }
}
