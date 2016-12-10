package controller.dto;

import model.Client;
import model.Product;

import java.util.Date;

/**
 * Created by igor on 29.11.16.
 */
public class ProductShortDto {
    private Long id;
    private String name;
    private Long productCol;
    private Date date;
    private Client client;

    public ProductShortDto() {
    }

    public ProductShortDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.productCol = product.getProductCol();
        this.date = product.getDate();
        this.client = product.getClient();
    }

    public Long getId() {
        return id;
    }

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
}
