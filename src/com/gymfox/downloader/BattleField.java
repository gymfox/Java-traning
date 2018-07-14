package com.gymfox.downloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BattleField {
    public static void main(String[] args) {
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9c/Image-Porkeri_001.jpg";

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            URL url = new URL(imageUrl);
            inputStream = url.openStream();
            outputStream = new FileOutputStream(new File("newImage13.jpg").getAbsolutePath());

            byte[] buffer = new byte[2400000];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException :- " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException :- " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException :- " + e.getMessage());

        } finally {
            try {

                inputStream.close();
                outputStream.close();

            } catch (IOException e) {
                System.out.println("Finally IOException :- " + e.getMessage());
            }
        }
    }
}
