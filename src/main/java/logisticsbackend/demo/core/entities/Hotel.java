package logisticsbackend.demo.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private Integer phone;
    private String email;
    private Boolean enable;
    
    // * Relations*/
    @ManyToOne
    private StarsCategory StarsCategory;

}
