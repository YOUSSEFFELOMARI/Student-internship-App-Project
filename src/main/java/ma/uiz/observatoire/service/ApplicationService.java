package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.dto.ApplicationDTO;
import ma.uiz.observatoire.mapper.ApplicationMapper;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.OfferRepository;
import ma.uiz.observatoire.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationtRepository;

    private final StudentRepository studentRepository;

    private final OfferRepository offerRepository;
    private final ApplicationMapper applicationMapper;
    public Page<Application> showAllApplication(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return applicationtRepository.findAll(pageable);
    }
    public List<ApplicationDTO> findByOfferId(int id){
        return  applicationtRepository.findByApplicationPkOfferOfferId(id)
                .stream().map(e-> applicationMapper.mapToDto(e)).toList();
    }
    public List<ApplicationDTO> findByStudentId(int id){
        return applicationtRepository.findByApplicationPkStudentStudentId(id)
                .stream().map(e-> applicationMapper.mapToDto(e)).toList();
    }
    public void create(Application applicationt) {
        if (applicationtRepository.existsById(applicationt.getApplicationPk()))
            throw new EntityExistsException("Application already stored in database - ID : "+applicationt.getApplicationPk()) {};
        applicationtRepository.save(applicationt);
    }

    public void delete(String id) {
        Application.ApplicationPk pk=getPkfromStr(id);
        if (!applicationtRepository.existsById(pk))
            throw new EntityNotFoundException("Application not found - ID : "+id) {};
        applicationtRepository.deleteById(pk);
    }

    public void update(Application applicationt) {
        if (!applicationtRepository.existsById(applicationt.getApplicationPk()))
            throw new EntityNotFoundException("Application not found - ID : "+applicationt.getApplicationPk()) {};
        applicationtRepository.save(applicationt);
    }

    public Application find(String id) {
        Application.ApplicationPk pk=getPkfromStr(id);
        return applicationtRepository.findById(pk).orElseThrow(() ->
                new EntityNotFoundException("Application not found - ID : "+id) {});
    }

    public Application.ApplicationPk getPkfromStr(String id){
        String[] spt = id.split(",", 2);
        Application.ApplicationPk pk=new Application.ApplicationPk();
        Student student=studentRepository.findById(Integer.parseInt(spt[1])).orElseThrow(() ->
                new EntityNotFoundException("Student not found - ID : "+id) {});
        Offer offer=offerRepository.findById(Integer.parseInt(spt[0])).orElseThrow(() ->
                new EntityNotFoundException("Offer not found - ID : "+id) {});
        pk.setOffer(offer);
        pk.setStudent(student);
        return pk;
    }

    public long count() {
        return applicationtRepository.count();
    }
}
