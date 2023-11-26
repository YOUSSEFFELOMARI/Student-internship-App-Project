package ma.uiz.observatoire.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ImgUtils {

    @Value("${pictures.folder}")
    private String fileSystemFolder;

    public String getFileExtension(String fileName) {
        int extensionIndex = fileName.lastIndexOf(".");
        if(extensionIndex == -1) return "";
        return fileName.substring(extensionIndex + 1);
    }
}
