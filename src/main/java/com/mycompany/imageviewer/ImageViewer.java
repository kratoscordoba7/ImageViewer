package com.mycompany.imageviewer;

import java.io.File;
import Model.Image;
import Persistence.FileImageLoader;

public class ImageViewer {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\gatete\\Documents\\NetBeansProjects\\ImageViewer\\Imagenes");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();       
        MainFrame mainFrame = new MainFrame(imageLoader);
        mainFrame.getImageDisplay().show(image);        
    }
}
