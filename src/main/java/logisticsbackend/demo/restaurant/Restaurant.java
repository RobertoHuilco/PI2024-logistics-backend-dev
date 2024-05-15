package logisticsbackend.demo.restaurant;

import logisticsbackend.demo.stars_category.StarsCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Integer price;
    // private image

    // * Relations*/
    @ManyToOne
    private StarsCategory StarsCategory;

}
