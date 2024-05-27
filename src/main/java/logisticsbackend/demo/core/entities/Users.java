package logisticsbackend.demo.core.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String fullNames;
    @NotNull
    private String lastNames;
    @NotNull
    private String dni;
    @NotNull
    private Integer phone;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String address;
    @NotNull
    private String genre;
    @NotNull
    private String bloodType;
    @NotNull
    private String birthday;
    @NotNull
    private String maritalState;
    @NotNull
    private String emergencyContact;
    @NotNull
    private Integer emergencyPhone;
    @NotNull
    private String disease;
    @NotNull
    private String disability;
    @NotNull
    private Boolean enable;

    // * Relations*/
    @ManyToOne
    private Role role;

    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "user_tour",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "tour_id")}
    )
    private Set<Tour> tours = new HashSet<>();

}
