package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by igor on 27.11.16.
 */
@Entity
@Table(name = "transports")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transport extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transport")
    private Long id;
    @Column(name = "height")
    private String height;
    @Column(name = "width")
    private String width;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "number_of_seats")
    private Long numberOfSeats;
    @Column(name = "number_of_remaining_places")
    private Long numberOfRemainingPlaces;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_transport")
    private TypeTransport typeTransport;
    @Column(name = "id_type_transport", updatable = false, insertable = false)
    private Long idTypeTransport;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public Long getIdTypeTransport() {
        return idTypeTransport;
    }

    public void setIdTypeTransport(Long idTypeTransport) {
        this.idTypeTransport = idTypeTransport;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }
}
