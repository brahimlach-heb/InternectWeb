package internect.internship.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private    Long id;
    private    String username;
    private    String password;
    private    Date born;
    private    Boolean RS;
    private    String ncs;

}
