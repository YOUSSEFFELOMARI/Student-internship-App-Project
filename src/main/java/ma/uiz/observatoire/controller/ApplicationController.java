package ma.uiz.observatoire.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uiz.observatoire.dto.ApplicationDTO;
import ma.uiz.observatoire.mapper.ApplicationMapper;
import ma.uiz.observatoire.model.Application;
import ma.uiz.observatoire.model.Response;
import ma.uiz.observatoire.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ma.uiz.observatoire.controller.CustomResponse.response;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper mapper;

    @GetMapping("/page/{pageNum}")
    public List<ApplicationDTO> displayAllApplication(@PathVariable(name = "pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        Page<Application> applicationPage = applicationService.showAllApplication(pageNum, pageSize);
        return applicationPage.getContent().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }
    @GetMapping
    public List<ApplicationDTO> getApplicationsByOfferOrStudent(HttpServletRequest request) {
        String offerIdParam = request.getParameter("offerId");
        String studentIdParam = request.getParameter("studentId");
        if (offerIdParam != null)
            return applicationService.findByOfferId(Integer.parseInt(offerIdParam));
        if (studentIdParam != null)
            return applicationService.findByStudentId(Integer.parseInt(studentIdParam));
        return new ArrayList<>();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> displayApplication(@PathVariable(name = "id") String id) {
        ResponseEntity<ApplicationDTO> resp= ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDto(applicationService.find(id)));
        return resp;
    }

    @PostMapping
    public ResponseEntity<Application> saveApplication(@Valid @RequestBody Application application) {
        application.setStatus(Application.AppStatus.PENDING);
        application.setApplicationDate(new Date());
        applicationService.create(application);
        return ResponseEntity.status(HttpStatus.OK).body(application);
    }


    @PutMapping
    public ResponseEntity<Response> updateApplication(@Valid @RequestBody Application application) {
        applicationService.update(application);
        return response("Application successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteApplication(@PathVariable String id) {
        applicationService.delete(id);
        return response("Application successfully deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countApplication(){
        return ResponseEntity.status(HttpStatus.OK).body(applicationService.count());
    }

}
