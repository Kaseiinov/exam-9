package kg.attractor.exam9.exceptions;

import java.util.NoSuchElementException;

public class RoleNotFoundException extends NoSuchElementException {
    public RoleNotFoundException() {
        super("Role not found");
    }
}
