package ma.uiz.observatoire.mapper;

import jakarta.persistence.EntityNotFoundException;
import ma.uiz.observatoire.dto.CompanyDTO;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@Mapper(componentModel = "spring")
public abstract class OfferMapper {

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    StudentDiplomaRepository studentDiplomaRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    StudentLanguageRepository studentLanguageRepository;
    @Autowired
    DiplomaTypeRepository diplomaTypeRepository;
    @Autowired
    DomainRepository domainRepository;
    @Autowired
    StudentRepository studentRepository;

    @Mapping(source = "studentLanguages",target = "languages")
    public abstract OfferDTO mapToDto(Offer offer);

    @Mapping(source = "languages",target = "studentLanguages")
    public abstract Offer mapToModel(OfferDTO offerDTO);

/*    @BeforeMapping
    public void beforeMapping(Offer offer) {
        offer.setApplications(new HashSet<>(applicationRepository.findByApplicationPkOfferOfferId(offer.getOfferId())));

    }*/

    @AfterMapping
    public void afterMapping(Offer offer) {
        offer.getApplications().forEach(a -> a.getApplicationPk().setOffer(offer));
    }


/*    protected Integer mapApplicationSourceToId(Application application){
        return application.getApplicationPk().getStudent().getStudentId();
    }*/

    protected String mapDiplomaTypeSourceToId(DiplomaType diplomaType){return diplomaType.getDiplomaTypeName();}
    protected String mapLanguageSourceToId(StudentLanguage studentLanguage){return studentLanguage.getLanguageName();}
    protected String mapDomainSourceToId(Domain domain){return domain.getDomainName();}

/*    protected Application mapIdtoApplicationSource(Integer id){
        Student student=studentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Student not found - ID : "+id) {});

        Application.ApplicationPk applicationPk= new Application.ApplicationPk();
        applicationPk.setStudent(student);

        Application application=new Application();
        application.setApplicationPk(applicationPk);

        return application;
    }*/

    protected Company mapIdtoCompanySource(CompanyDTO s){
        return companyRepository.findById(s.getCompanyId()).orElseThrow(() ->
                new EntityNotFoundException("Company not found - Name : "+s) {});
    }

    protected DiplomaType mapIdtoDiplomaTypeSource(String s){
        return diplomaTypeRepository.findByDiplomaTypeName(s).orElseThrow(() ->
                new EntityNotFoundException("Diploma Type not found - Name : "+s) {});
    }

    protected StudentLanguage mapIdToLanguageSource(String s) {
        return studentLanguageRepository.findByLanguageName(s).orElseThrow(() ->
                new EntityNotFoundException("Student Language not found - Name : "+s) {});
    }

    protected Domain mapIdToDomainSource(String s) {
        return domainRepository.findByDomainName(s).orElseThrow(() ->
                new EntityNotFoundException("Domain not found - Name : "+s) {});
    }

    protected String mapDateToFormattedDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat();
        if(date==null) return "";
        formatter.applyPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    protected Date mapFormattedDateToDate(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat();
                formatter.applyPattern("yyyy-MM-dd HH:mm");
        Date date= formatter.parse(s);
        date.setHours(date.getHours()+1);
        return date;
    }

}

