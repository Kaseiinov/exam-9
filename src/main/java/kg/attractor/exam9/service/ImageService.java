package kg.attractor.exam9.service;

import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<?> findByName(String imageName);
}
