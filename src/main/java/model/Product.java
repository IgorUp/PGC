package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by igor on 24.11.16.
 */
@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends AbstractPersistable<String> {

    @Id
    @Column(name = "id_product")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "productcol")
    private Long productCol;
    @Column(name = "date")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;
    @Column(name = "id_user", updatable = false, insertable = false)
    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
