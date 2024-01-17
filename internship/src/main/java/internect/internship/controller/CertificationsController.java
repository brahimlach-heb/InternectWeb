package internect.internship.controller;

import internect.internship.Models.Certifications;
import internect.internship.service.CertificationsService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@WebService(name = "/certifications")
public class CertificationsController {

    private final CertificationsService certificationsService;

    @Autowired
    public CertificationsController(CertificationsService certificationsService) {
        this.certificationsService = certificationsService;
    }

    @WebMethod
    public List<Certifications> getAllCertifications() {
        return certificationsService.getAllCertifications();
    }

    @WebMethod(operationName = "/{id}")
    public Certifications getCertificationById(@WebParam Integer id) {
        return certificationsService.getCertificationById(id);
    }

    @WebMethod
    public Certifications addCertification(@WebParam Certifications certification) {
        return certificationsService.addCertification(certification);
    }

    @WebMethod(operationName = "/{id}")
    public Certifications updateCertification(@WebParam Integer id, @WebParam Certifications certification) {
        return certificationsService.updateCertification(id, certification);
    }

    @WebMethod(operationName = "/{id}")
    public void deleteCertification(@WebParam Integer id) {
        certificationsService.deleteCertification(id);
    }
}
