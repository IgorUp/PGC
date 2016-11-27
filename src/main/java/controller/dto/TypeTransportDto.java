package controller.dto;


import model.TypeTransport;

/**
 * Created by igor on 27.11.16.
 */
public class TypeTransportDto {
    private Long id;
    private String nameTransport;
    private Long transportCol;
    private ProductDto product;
    private String idProduct;

    public TypeTransportDto() {
    }

    public TypeTransportDto(TypeTransport typeTransport) {
        this.id = typeTransport.getId();
        this.nameTransport = typeTransport.getNameTransport();
        this.transportCol = typeTransport.getTransportCol();
        this.product = new ProductDto(typeTransport.getProduct());
        this.idProduct = typeTransport.getIdProduct();
    }

    public Long getId() {
        return id;
    }

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
