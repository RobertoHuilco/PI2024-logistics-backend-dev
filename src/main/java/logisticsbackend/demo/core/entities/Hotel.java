package logisticsbackend.demo.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Integer phone;
    @NotNull
    private String email;
    @NotNull
    private Boolean enable;
    
    // * Relations*/
    @ManyToOne
    private StarsCategory StarsCategory;

}
