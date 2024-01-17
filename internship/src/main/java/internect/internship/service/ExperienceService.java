package internect.internship.service;


import internect.internship.Models.Experience;
import internect.internship.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceById(Long id) {
        Optional<Experience> optionalExperience = experienceRepository.findById(id);
        return optionalExperience.orElse(null);
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(Long id, Experience updatedExperience) {
        if (experienceRepository.existsById(id)) {
            updatedExperience.setExperienceId(id);
            return experienceRepository.save(updatedExperience);
        }
        return null;
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}

