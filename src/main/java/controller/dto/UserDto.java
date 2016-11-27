package controller.dto;

import model.User;

/**
 * Created by igor on 24.11.16.
 */
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String compani;
    private String firstName;
    private String lastName;

    public UserDto() {
    }

    public UserDto(User user) {

        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.compani = user.getCompani();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();

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
}
