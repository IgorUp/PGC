package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by igor on 27.11.16.
 */
@Entity
@Table(name = "type_transports")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeTransport extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_transport")
    private Long id;
    @Column(name = "name_transport")
    private String nameTransport;
    @Column(name = "transport_col")
    private Long transportCol;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_product")
    private Product product;
    @Column(name = "id_product", updatable = false, insertable = false)
    private String idProduct;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTransport() {
        return nameTransport;
    }

    public void setNameTransport(String nameTransport) {
        this.nameTransport = nameTransport;
    }

    public Long getTransportCol() {
        return transportCol;
    }

    public void setTransportCol(Long transportCol) {
        this.transportCol = transportCol;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}
