package Products.Physical;

import Products.PhysicalProduct;
import ProductInfos.MusicInfo;

public class PhysicalMusic extends PhysicalProduct {

    private MusicInfo musicInfo;

    public PhysicalMusic(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }
}
