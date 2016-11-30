package controller.dto;

import model.TypeStock;

/**
 * Created by igor on 27.11.16.
 */
public class TypeStockDto {
    private String id;
    private String name;
    private ProductDto product;
    private String idProduct;

    public TypeStockDto() {
    }

    public TypeStockDto(TypeStock typeStock) {
        this.id = typeStock.getId();
        this.name = typeStock.getName();
        this.product = new ProductDto(typeStock.getProduct());
        this.idProduct = typeStock.getIdProduct();
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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}
