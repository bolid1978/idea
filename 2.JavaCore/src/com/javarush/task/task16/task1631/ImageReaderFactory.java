package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types) throws IllegalAccessException {
        if (types==null)  throw new IllegalArgumentException("Неизвестный тип картинки");
        if (types.equals(ImageTypes.JPG)) {
            return new JpgReader();
        }  else if  (types.equals(ImageTypes.PNG)) {
            return new PngReader();
        }   else if (types.equals(ImageTypes.BMP)){
            return  new BmpReader();
        }

           else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}