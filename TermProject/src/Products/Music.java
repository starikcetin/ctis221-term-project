package Products;

import Core.Product;
import ProductMetadata.MusicInfo;

public class Music extends Product {

    private MusicInfo musicInfo;

    public Music(MusicInfo musicInfo) {
        this.musicInfo = musicInfo;
    }
}
