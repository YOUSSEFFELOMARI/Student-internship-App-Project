package ma.uiz.observatoire.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.service.ImgService;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImgService imgService;

    @GetMapping( value = "/{image}")
    public void displayImage(@PathVariable(name = "image") String img,
                             HttpServletResponse response) throws IOException {
            InputStream resource = imgService.getImage(img);
            StreamUtils.copy(resource, response.getOutputStream());
    }
}
