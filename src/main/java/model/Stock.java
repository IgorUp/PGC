package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Entity
@Table(name = "stocks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stock")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "number_of_seats")//колличество мест
    private Long numberOfSeats;
    @Column(name = "number_of_remaining_places") // осталось мест
    private Long numberOfRemainingPlaces;
    @Column(name = "number_of_sectors")
    private Long numberOfSectors;
    @Column(name = "height")
    private String height;
    @Column(name = "width")
    private String width;
    @Column(name = "capacity")
    private String capacity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type_stock")
    private TypeStock typeStock;
    @Column(name = "id_type_stock", insertable = false, updatable = false)
    private String idTypeStock;
    @ManyToMany
    @JoinTable(name = "link_stocks_products", joinColumns = @JoinColumn(name = "id_stock"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getNumberOfRemainingPlaces() {
        return numberOfRemainingPlaces;
    }

    public void setNumberOfRemainingPlaces(Long numberOfRemainingPlaces) {
        this.numberOfRemainingPlaces = numberOfRemainingPlaces;
    }

    public Long getNumberOfSectors() {
        return numberOfSectors;
    }

    public void setNumberOfSectors(Long numberOfSectors) {
        this.numberOfSectors = numberOfSectors;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public TypeStock getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(TypeStock typeStock) {
        this.typeStock = typeStock;
    }

    public String getIdTypeStock() {
        return idTypeStock;
    }

    public void setIdTypeStock(String idTypeStock) {
        this.idTypeStock = idTypeStock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
