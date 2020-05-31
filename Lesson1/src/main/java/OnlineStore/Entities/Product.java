package OnlineStore.Entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal cost;

    @Column
    private String path_image;

//    @ManyToMany
//    @JoinTable(
//            name = "orders",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id")
//    )
//    private List<Persons> persons;
//
//    @OneToMany(mappedBy = "orders")
//    List<Orders> orders;

    public Product(){

    }

    public Product(String name, String description, BigDecimal cost, String path_image){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.path_image = path_image;
    }

    public Product(Long id, String name, String description, BigDecimal cost, String path_image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.path_image = path_image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getPath_image() {
        return path_image;
    }

    //    public List<Persons> getPerson() {
//        return persons;
//    }
//
//    public List<Orders> getOrders() {
//        return orders;
//    }
}
