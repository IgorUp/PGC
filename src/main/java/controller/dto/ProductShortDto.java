package controller.dto;

import model.Product;

import java.util.Date;

/**
 * Created by igor on 29.11.16.
 */
public class ProductShortDto {
    private String id;
    private String name;
    private Long productCol;
    private Date date;

    public ProductShortDto() {
    }

    public ProductShortDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.productCol = product.getProductCol();
        this.date = product.getDate();
    }

    public String getId() {
        return id;
    }

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
}
