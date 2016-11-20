package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by igor on 20.11.16.
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    private String id_role;
    @Column(name = "name")
    private String name;

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
