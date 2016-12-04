package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by igor on 24.11.16.
 */
@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends AbstractPersistable<Long> {

    @Id
    @Column(name = "id_product")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "productcol")
    private Long productCol;
    @Column(name = "date")
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;
    @Column(name = "id_client", insertable = false, updatable = false)
    private Long idClient;
    @ManyToMany(mappedBy = "products")
/*    @JoinTable(name = "link_stocks_products", joinColumns = @JoinColumn(name = "id_stock"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))*/
    private List<Stock> stocks;

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

    public Long getProductCol() {
        return productCol;
    }

    public void setProductCol(Long productCol) {
        this.productCol = productCol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
