package internect.internship.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer id;
    private  String  about;
}
