package ma.uiz.observatoire.mapper;

import ma.uiz.observatoire.dto.*;
import ma.uiz.observatoire.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ApplicationMapper {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private OfferMapper offerMapper;

    @Mapping(target = "offer",expression = "java(getOfferFromApp(app))")
    @Mapping(target = "student",expression = "java(getStudentFromApp(app))")
    public abstract ApplicationDTO mapToDto(Application app);
    protected StudentDTO getStudentFromApp(Application app){
        return studentMapper.mapToDto(app.getApplicationPk().getStudent());
    }
    protected OfferDTO getOfferFromApp(Application app){
        return offerMapper.mapToDto(app.getApplicationPk().getOffer());
    }
}
