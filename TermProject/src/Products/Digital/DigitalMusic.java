package Products.Digital;

import Products.DigitalProduct;
import Products.Infos.MusicInfo;

public class DigitalMusic extends DigitalProduct {

    private MusicInfo musicInfo;

    public DigitalMusic(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }
}
