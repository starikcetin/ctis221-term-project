package Products.Digital;

import Products.DigitalProduct;
import ProductInfos.MusicInfo;

public class DigitalMusic extends DigitalProduct {

    private MusicInfo musicInfo;

    public DigitalMusic(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }
}
