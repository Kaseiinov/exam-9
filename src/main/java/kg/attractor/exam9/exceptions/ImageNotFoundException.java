package kg.attractor.exam9.exceptions;

import java.util.NoSuchElementException;

public class ImageNotFoundException extends NoSuchElementException {
    public ImageNotFoundException() {
        super("Image not found");
    }
}
