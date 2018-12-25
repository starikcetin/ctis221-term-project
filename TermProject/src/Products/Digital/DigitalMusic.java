package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.MusicInfo;
import Products.Interfaces.IMusic;
import Products.ProductInfo;
import Products.ProductType;

public class DigitalMusic extends DigitalProduct implements IMusic {

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
