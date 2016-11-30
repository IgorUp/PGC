package controller.dto;

import model.Product;
import model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 29.11.16.
 */
public class UserShortDto {
    private Long id;
    private String name;
    private String email;
    private String compani;
    private String firstName;
    private String lastName;
    private List<ProductShortDto> productShortDtos;

    public UserShortDto() {
    }

    public UserShortDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.compani = user.getCompani();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        if(user.getProducts() != null){
            productShortDtos = new ArrayList<>(user.getProducts().size());
            for (Product product : user.getProducts()) {
                productShortDtos.add(new ProductShortDto(product));
            }
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompani() {
        return compani;
    }

    public void setCompani(String compani) {
        this.compani = compani;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductShortDto> getProductShortDtos() {
        return productShortDtos;
    }

    public void setProductShortDtos(List<ProductShortDto> productShortDtos) {
        this.productShortDtos = productShortDtos;
    }
}
