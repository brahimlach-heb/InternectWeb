package internect.internship.repository;


import internect.internship.Models.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationsRepository extends JpaRepository<Certifications, Integer> {
    // You can add custom query methods if needed
}

