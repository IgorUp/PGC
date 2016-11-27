package controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.Product;
import model.User;

import java.util.Date;

/**
 * Created by igor on 24.11.16.
 */
public class ProductDto {

    private String id;
    private String name;
    private Long productCol;
    private Date date;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UserDto userDto;
    private Long idUser;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.productCol = product.getProductCol();
        this.date = product.getDate();
        this.userDto = new UserDto(product.getUser());
        this.idUser = product.getIdUser();
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
