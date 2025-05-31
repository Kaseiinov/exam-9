package kg.attractor.exam9.service.impl;


import kg.attractor.exam9.service.ImageService;
import kg.attractor.exam9.service.UserService;
import kg.attractor.exam9.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final FileUtil fileUtil;
    private final UserService userService;


    @Override
    public ResponseEntity<?> findByName(String imageName) {
        return fileUtil.getOutputFile(imageName, "company/", MediaType.IMAGE_JPEG);
    }

//    @Override
//    public ResponseEntity<?> findById(long imageId) {
//        UserImage image = userImageRepository.findById(imageId).orElseThrow(ImageNotFoundException::new);
//        String filename = image.getFileName();
//        log.info("Found image with name: {}", filename);
//        return fileUtil.getOutputFile(filename, "images/", MediaType.IMAGE_JPEG);
//    }
//
//    @Override
//    public ResponseEntity<?> findByUserId(long userId) {
//        UserImage image = userImageRepository.findByUser_Id(userId).orElseThrow(ImageNotFoundException::new);
//        String filename = image.getFileName();
//        return fileUtil.getOutputFile(filename, "images/", MediaType.IMAGE_JPEG);
//    }

}
