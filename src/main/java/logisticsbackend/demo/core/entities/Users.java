package logisticsbackend.demo.core.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class Users {
    @Id // Para identificar el id de la tabla en la BDD
    @GeneratedValue(strategy = GenerationType.AUTO) // Para generar un AutoId
    private long id;
    private String fullNames;
    private String lastNames;
    private String dni;
    private Integer phone;
    private String email;
    private String password;
    private String address;
    private String genre;
    private String bloodType;
    private String birthday;
    private String maritalState;
    private String emergencyContact;
    private Integer emergencyPhone;
    private String disease;
    private String disability;
    private Boolean enable;

    // * Relations*/
    @ManyToOne
    private Role Role;

    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "user_tour",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "tour_id")}
    )
    private Set<Tour> tours = new HashSet<>();

}
