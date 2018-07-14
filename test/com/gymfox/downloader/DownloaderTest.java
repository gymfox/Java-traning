package com.gymfox.downloader;

import org.junit.jupiter.api.Test;

public class DownloaderTest {
    @Test
    public void downloadTest() {
        Downloader download = new Downloader("https://upload.wikimedia.org/wikipedia/commons/9/9c/Image-Porkeri_001.jpg");

        download.downloadImage();
    }
}
