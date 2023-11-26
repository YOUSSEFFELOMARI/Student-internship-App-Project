package ma.uiz.observatoire.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.utils.ImgUtils;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@RequiredArgsConstructor
public class ImgService {
    private final ImgUtils imgUtils;

    public InputStream getImage(String img) {
        String path=imgUtils.getFileSystemFolder()+ File.separator+img;
        System.out.println(path);
        try{
            return new FileInputStream(path);
        }
        catch(FileNotFoundException e){
            throw new EntityNotFoundException();
        }
    }
}
