package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Establishment;
import ma.uiz.observatoire.repository.EstablishmentRepository;
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
public class EstablishmentService {
    private final ImgUtils imgUtils;

    private final EstablishmentRepository establishmentRepository;

    public Page<Establishment> showAllEstablishment(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return establishmentRepository.findAll(pageable);
    }

    public List<Establishment> findAll(Integer univId) {
        if (univId!=null)
            return establishmentRepository.findAllByUniversityUniversityId(univId);
        return establishmentRepository.findAll();
    }

    public long count() {
        return establishmentRepository.count();
    }

    public Establishment create(Establishment establishment) {
        if (establishmentRepository.existsById(establishment.getEstablishmentId()))
            throw new EntityExistsException("Establishment already stored in database - ID : " +
                    establishment.getEstablishmentId()) {};
        return establishmentRepository.save(establishment);
    }

    public Establishment update(Establishment establishment) {
        if (!establishmentRepository.existsById(establishment.getEstablishmentId()))
            throw new EntityNotFoundException("Establishment not found - ID : " +
                    establishment.getEstablishmentId()) {};
        return establishmentRepository.save(establishment);
    }

    public void delete(int id) {
        if (!establishmentRepository.existsById(id))
            throw new EntityNotFoundException("Establishment not found - ID : "+id) {};
        Establishment establishment=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+establishment.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()) oldImg.delete();
        establishmentRepository.deleteById(id);
    }

    public Establishment find(int id) {
        return establishmentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Establishment not found - ID : "+id) {});
    }
    public void addEstablishmentWithImg(Establishment e, MultipartFile img){
        if(img.isEmpty()) {
            create(e);
            return;
        }
        try{
            String imageName="establishment_"+(new Date()).getTime()+"."
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
        Establishment e=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        try{
            String imageName="establishment_"+(new Date()).getTime()+"."
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
        Establishment e=find(id);

        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()){ oldImg.delete();}else{
            throw new EntityNotFoundException("Image not found") {};
        };

        e.setImageUrl(null);
        update(e);
    }

}
