package kg.attractor.exam9.service;

import kg.attractor.exam9.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

import java.util.NoSuchElementException;

public interface ErrorService {
    ErrorResponseBody makeResponse(NoSuchElementException e);

    ErrorResponseBody makeResponse(Exception e);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
