package controller.dto;

import model.TypeStock;

/**
 * Created by igor on 27.11.16.
 */
public class TypeStockDto {
    private String id;
    private String name;

    public TypeStockDto() {
    }

    public TypeStockDto(TypeStock typeStock) {
        this.id = typeStock.getId();
        this.name = typeStock.getName();
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
}
