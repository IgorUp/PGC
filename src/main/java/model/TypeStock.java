package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by igor on 27.11.16.
 */
@Entity
@Table(name = "type_stocks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeStock extends AbstractPersistable<String> {

    @Id
    @Column(name = "id_type_stock")
    private String id;
    @Column(name = "name")
    private String name;

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
}
