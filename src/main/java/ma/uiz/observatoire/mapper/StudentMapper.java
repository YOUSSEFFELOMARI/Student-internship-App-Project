package ma.uiz.observatoire.mapper;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.model.*;
import ma.uiz.observatoire.repository.ApplicationRepository;
import ma.uiz.observatoire.repository.StudentDiplomaRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    StudentDiplomaRepository studentDiplomaRepository;
    @Mapping(source = "account.accountId",target = "account")
    public abstract StudentDTO mapToDto(Student s);

    public abstract Student mapToModel(StudentDTO s);

    @BeforeMapping
    public void beforeMapping(Student student) {
        student.setStudentDiplomas(new HashSet<>(studentDiplomaRepository.findByStudentDiplomaIdStudentStudentId
                (student.getStudentId())));
        student.setApplications(new HashSet<>(applicationRepository.findByApplicationPkStudentStudentId
                (student.getStudentId())));
    }
    @AfterMapping
    public void afterMapping(Student student) {
      /*  student.getApplication().forEach(a -> a.getApplicationPk().setStudent(student));*/
        student.getStudentDiplomas().forEach(a -> a.getStudentDiplomaId().setStudent(student));
    }


    protected Integer mapStudentDiplomaSourceToId(StudentDiploma studentDiploma){
        return  studentDiploma.getStudentDiplomaId().getDiploma().getDiplomaId();
    }

/*    protected Integer mapStudentDiplomaSourceToId(Application application) {
        return application.getApplicationPk().getOffer().getOfferId();
    }*/

    protected Integer mapCertificateSourceToId(StudentCertificate certificate) {
        return certificate.getCertificateId();
    }
    protected Integer mapExperienceSourceToId(StudentExperience experience) {
        return experience.getExperienceId();
    }
    protected Integer mapHobbySourceToId(StudentHobby hobby) {
        return hobby.getHobbyId();
    }
    protected Integer mapLanguageSourceToId(StudentLanguage language) {
        return language.getLanguageId();
    }
    protected Integer mapSkillSourceToId(StudentSkill skill) {
        return skill.getSkillId();
    }
    protected Integer mapLicenceSourceToId(StudentLicence license) {
        return license.getLicenceId();
    }
    protected StudentDiploma mapIdtoStudentDiplomaSource(Integer id){
        Diploma diploma=new Diploma();
        diploma.setDiplomaId(id);
        StudentDiploma.StudentDiplomaPk studentDiplomaPk= new StudentDiploma.StudentDiplomaPk();
        studentDiplomaPk.setDiploma(diploma);
        StudentDiploma studentDiploma=new StudentDiploma();
        studentDiploma.setStudentDiplomaId(studentDiplomaPk);
        return studentDiploma;
    }
/*    protected Application mapIdtoApplicationSource(Integer id){
        Offer offer=new Offer();
        offer.setOfferId(id);
        Application.ApplicationPk applicationPk= new Application.ApplicationPk();
        applicationPk.setOffer(offer);
        Application application=new Application();
        application.setApplicationPk(applicationPk);
        return application;
    }*/

    protected StudentCertificate mapIdToCertificateSource(Integer id) {
        StudentCertificate studentCertificate=new StudentCertificate();
        studentCertificate.setCertificateId(id);
        return studentCertificate;
    }
    protected StudentExperience mapIdToExperienceSource(Integer id) {
        StudentExperience studentExperience=new StudentExperience();
        studentExperience.setExperienceId(id);
        return studentExperience;
    }
    protected StudentHobby mapIdToHobbySource(Integer id) {
        StudentHobby studentHobby=new StudentHobby();
        studentHobby.setHobbyId(id);
        return studentHobby;
    }
    protected StudentLanguage mapIdToLanguageSource(Integer id) {
        StudentLanguage studentLanguage=new StudentLanguage();
        studentLanguage.setLanguageId(id);
        return studentLanguage;
    }
    protected StudentSkill mapIdToSkillSource(Integer id) {
        StudentSkill studentSkill=new StudentSkill();
        studentSkill.setSkillId(id);
        return studentSkill;
    }
    protected StudentLicence mapIdToLicenceSource(Integer id) {
        StudentLicence studentLicence=new StudentLicence();
        studentLicence.setLicenceId(id);
        return studentLicence;
    }

    protected Account mapIdAccountSource(Integer id) {
        Account account=new Account();
        account.setAccountId(id);
        return account;
    }
}
