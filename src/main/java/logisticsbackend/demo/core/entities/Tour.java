package logisticsbackend.demo.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.ManyToOne;

@Entity
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer days_duration;
    @NotNull
    private String sector;
    @NotNull
    private Integer capacity_quotes;
    // private image
    @NotNull
    private Date start_date;
    @NotNull
    private Boolean enable;

    // * Relations*/
    @ManyToOne
    private Hotel Hotel;

    @ManyToOne
    private Restaurant Restaurant;

    @ManyToOne
    private Transport Transport;

    @ManyToMany(mappedBy = "tours")
    private Set<Users> users = new HashSet<>();

}