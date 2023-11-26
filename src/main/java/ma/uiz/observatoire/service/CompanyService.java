package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.model.Company;
import ma.uiz.observatoire.repository.CompanyRepository;
import ma.uiz.observatoire.utils.ImgUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ImgUtils imgUtils;

    public Page<Company> showAllCompany(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return companyRepository.findAll(pageable);
    }

    public Company create(Company company) {
        if (companyRepository.existsById(company.getCompanyId()))
            throw new EntityExistsException("Company already stored in database - ID : "+company.getCompanyId()) {};
        return companyRepository.save(company);
    }

    public void delete(int id) {
        if (!companyRepository.existsById(id))
            throw new EntityNotFoundException("Company not found - ID : "+id) {};
        Company company=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+company.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()) oldImg.delete();
        companyRepository.deleteById(id);
    }

    public void update(Company company) {
        if (!companyRepository.existsById(company.getCompanyId()))
            throw new EntityNotFoundException("Company not found - ID : "+company.getCompanyId()) {};
        companyRepository.save(company);
    }

        public Company find(int id) {
        return companyRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Company not found - ID : "+id) {});
    }
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public long count() {
        return companyRepository.count();
    }


    public void addCompanyWithImg(Company company, MultipartFile img) throws IOException {
        if(img.isEmpty()) {
            create(company);
            return;
        }
       /* try{*/
            String imageName="company_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path=Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            company.setImageUrl("/"+imageName);
            create(company);
        /*}catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException();
        }*/
    }

    public void updateImg(int id, MultipartFile img) {
        if(img.isEmpty()) return;
        Company company=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+company.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        try{
            String imageName="company_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path=Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            company.setImageUrl("/"+imageName);
            update(company);
           if(oldImg.exists()) oldImg.delete();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void deleteImg(int id) {
        Company company=find(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+company.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()){ oldImg.delete();}else{
            throw new EntityNotFoundException("Image not found") {};
        };

        company.setImageUrl(null);
        update(company);
    }
}
