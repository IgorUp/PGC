package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by igor on 27.11.16.
 */
@Entity
@Table(name = "type_stocks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeStock extends AbstractPersistable<String> {

    @Id
    @Column(name = "id_type_stock")
    private String id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_product")
    private Product product;
    @Column(name = "id_product", updatable = false, insertable = false)
    private String idProduct;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
