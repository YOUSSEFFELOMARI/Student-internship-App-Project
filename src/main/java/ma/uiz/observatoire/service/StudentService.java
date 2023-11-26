package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.dto.StudentDTO;
import ma.uiz.observatoire.mapper.StudentMapper;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.repository.StudentRepository;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;
    private final ImgUtils imgUtils;

    public Page<StudentDTO> showAllStudent(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return studentRepository.findAll(pageable).map(mapper::mapToDto);
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public long count() {
        return studentRepository.count();
    }

    public StudentDTO create(StudentDTO studentDTO) {
        Student student= mapper.mapToModel(studentDTO);
        if (studentRepository.existsById(student.getStudentId()))
            throw new EntityExistsException("Student already stored in database - ID : "+student.getStudentId()) {};
        return mapper.mapToDto(studentRepository.save(student)) ;
    }
    public StudentDTO createStd(Student student) {
        if (studentRepository.existsById(student.getStudentId()))
            throw new EntityExistsException("Student already stored in database - ID : "+student.getStudentId()) {};
        return mapper.mapToDto(studentRepository.save(student));
    }
    public void delete(int id) {
        if (!studentRepository.existsById(id))
            throw new EntityNotFoundException("Student not found - ID : "+id) {};
        Student e=findStd(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()) oldImg.delete();
        studentRepository.deleteById(id);
    }

    public StudentDTO update(StudentDTO studentDTO) {
        Student student= mapper.mapToModel(studentDTO);
        if (!studentRepository.existsById(student.getStudentId()))
            throw new EntityNotFoundException("Student not found - ID : "+student.getStudentId()) {};
        return mapper.mapToDto(studentRepository.save(student)) ;
    }
    public Student updateStd(Student student) {
        if (!studentRepository.existsById(student.getStudentId()))
            throw new EntityNotFoundException("Student not found - ID : "+student.getStudentId()) {};
        return studentRepository.save(student);
    }
    public StudentDTO find(int id) {
        Student student= studentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Student not found - ID : "+id) {});
        return mapper.mapToDto(student);
    }
    public Student findStd(int id) {
        Student student= studentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Student not found - ID : "+id) {});
        return studentRepository.save(student);
    }
    public StudentDTO addStudentWithImg(StudentDTO studentDTO, MultipartFile img){
        Student student=mapper.mapToModel(studentDTO);
        if(img.isEmpty()) {
            return create(studentDTO);
        }
        try{
            String imageName="student_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path=Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            student.setImageUrl("/"+imageName);
            return createStd(student);
        }catch (Exception ex){
            log.error(ex.getMessage());
            throw new RuntimeException();
        }
    }

    public void updateImg(int id, MultipartFile img) {
        if(img.isEmpty()) return;
        Student e=findStd(id);
        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        try{
            String imageName="student_"+(new Date()).getTime()+"."
                    +imgUtils.getFileExtension(img.getOriginalFilename());
            var path= Path.of(imgUtils.getFileSystemFolder(),imageName).toString();
            img.transferTo(new File(path));
            e.setImageUrl("/"+imageName);
            updateStd(e);
            if(oldImg.exists()) oldImg.delete();
        }catch (Exception ex){
            log.error(ex.getMessage());
            throw new RuntimeException();
        }
    }

    public void deleteImg(int id) {
        Student e=findStd(id);

        String oldImgPath=imgUtils.getFileSystemFolder()+e.getImageUrl();
        File oldImg=new File(oldImgPath!=null?oldImgPath:"");
        if(oldImg.exists()){ oldImg.delete();}else{
            throw new EntityNotFoundException("Image not found") {};
        };

        e.setImageUrl(null);
        updateStd(e);
    }
}
