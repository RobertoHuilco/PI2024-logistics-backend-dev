package logisticsbackend.demo.tour;

import logisticsbackend.demo.hotel.Hotel;
import logisticsbackend.demo.transport.Transport;
import logisticsbackend.demo.restaurant.Restaurant;
import logisticsbackend.demo.user.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ManyToOne;

@Entity
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String names;
    private String description;
    private String dni;
    private Integer price;
    private Integer days_duration;
    private String tour_sector;
    private Integer ability;
    // private image
    private Date start_date;
    private Boolean bull_status;

    // * Relations*/
    @ManyToOne
    private Hotel Hotel;

    @ManyToOne
    private Restaurant Restaurant;

    @ManyToOne
    private Transport Transport;

    // @ManyToMany
    // private User User;

    @ManyToMany(mappedBy = "tours")
    private Set<Users> users = new HashSet<>();

}