package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.University;
import ma.uiz.observatoire.repository.UniversityRepository;
import ma.uiz.observatoire.utils.ImgUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UniversityService {
    private final ImgUtils imgUtils;
    private final UniversityRepository universityRepository;

    public Page<University> showAllUniversity(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return universityRepository.findAll(pageable);
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public long count() {
        return universityRepository.count();
    }

    public University create(University university) {
        if (universityRepository.existsById(university.getUniversityId()))
            throw new EntityExistsException("University already stored in database - ID : " +
                    university.getUniversityId()) {};
        return universityRepository.save(university);
    }

    public University update(University university) {
        if (!universityRepository.existsById(university.getUniversityId()))
            throw new EntityNotFoundException("University not found - ID : " +
                    university.getUniversityId()) {};
        return universityRepository.save(university);
    }

    public void delete(int id) {
        if (!universityRepository.existsById(id))
            throw new EntityNotFoundException("University not found - ID : "+id) {};
        University e=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()) oldImg.delete();
        universityRepository.deleteById(id);
    }

    public University find(int id) {
        return universityRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("University not found - ID : "+id) {});
    }
    public void addUniversityWithImg(University e, MultipartFile img){
        if(img.isEmpty()) {
            create(e);
            return;
        }
        try{
            String imageName="university_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path=Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            e.setImageUrl("/"+imageName);
            create(e);
        }catch (Exception ex){
            log.error(ex.getMessage());
            throw new RuntimeException();
        }
    }

    public void updateImg(int id, MultipartFile img) {
        if(img.isEmpty()) return;
        University e=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        try{
            String imageName="university_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path= Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            e.setImageUrl("/"+imageName);
            update(e);
            if(oldImg.exists()) oldImg.delete();
        }catch (Exception ex){
            log.error(ex.getMessage());
            throw new RuntimeException();
        }
    }

    public void deleteImg(int id) {
        University e=find(id);

        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()){ oldImg.delete();}else{
            throw new EntityNotFoundException("Image not found") {};
        };

        e.setImageUrl(null);
        update(e);
    }
}
