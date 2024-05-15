package logisticsbackend.demo.transport;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int price;
    private int capacity;
}