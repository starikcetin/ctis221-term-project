package Products.Physical;

import Products.PhysicalProduct;
import Products.Infos.MusicInfo;
import Products.ProductInfo;

public class PhysicalMusic extends PhysicalProduct {

    private MusicInfo musicInfo;

    public PhysicalMusic(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }

    @Override
    public ProductInfo getProductInfo() {
        return musicInfo;
    }    
}
