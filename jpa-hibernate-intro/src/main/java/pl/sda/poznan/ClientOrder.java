package pl.sda.poznan;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clientOrders")
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

//    @ManyToMany(mappedBy = "clientOrders")
//    private Set<ClientOrder> clientOrders = new HashSet<>();

}
