package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.MusicInfo;
import Products.Interfaces.IMusic;
import Products.ProductInfo;
import Products.ProductType;

public class PhysicalMusic extends PhysicalProduct implements IMusic {

    private MusicInfo musicInfo;

    public PhysicalMusic(MusicInfo musicInfo) {
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
