package internect.internship.controller;

import internect.internship.Models.Experience;
import internect.internship.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.createExperience(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}
