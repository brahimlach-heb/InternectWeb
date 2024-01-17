package internect.internship.service;


import internect.internship.Models.Certifications;
import internect.internship.repository.CertificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationsService {

    private final CertificationsRepository certificationsRepository;

    @Autowired
    public CertificationsService(CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository;
    }

    public List<Certifications> getAllCertifications() {
        return certificationsRepository.findAll();
    }

    public Certifications getCertificationById(Integer id) {
        Optional<Certifications> optionalCertification = certificationsRepository.findById(id);
        return optionalCertification.orElse(null);
    }

    public Certifications addCertification(Certifications certification) {
        return certificationsRepository.save(certification);
    }

    public Certifications updateCertification(Integer id, Certifications newCertification) {
        Optional<Certifications> optionalCertification = certificationsRepository.findById(id);
        if (optionalCertification.isPresent()) {
            Certifications existingCertification = optionalCertification.get();
            existingCertification.setName(newCertification.getName());
            existingCertification.setUrl(newCertification.getUrl());
            existingCertification.setOrganization(newCertification.getOrganization());
            existingCertification.setDate_certif(newCertification.getDate_certif());
            existingCertification.setCredentialId(newCertification.getCredentialId());

            return certificationsRepository.save(existingCertification);
        }
        return null;
    }

    public void deleteCertification(Integer id) {
        certificationsRepository.deleteById(id);
    }
}
