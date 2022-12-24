package Model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.mycompany.imageviewer.AccessCounter;

public class ImageV2 implements Image{

    private final Image realImage;

    public ImageV2(File file) {
        this.realImage = new ImageV1(file.getName(), this.getStream(file));
    }
    
    public InputStream getStream(File file) {
        try {
            return new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    
    @Override
    public String name() {
        return this.realImage.name();
    }

    @Override
    public InputStream stream() {
        Integer count = AccessCounter.getInstance().increment(this.name());
        System.out.printf("File '%s' accessed '%d' times.\n", this.name(), count);
        return this.realImage.stream();
    }
}
