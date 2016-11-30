package service;

import model.TypeStock;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
public interface TypeStockService {
    TypeStock get(String id);
    String create(TypeStock typeStock);
    void delete(TypeStock typeStock);
    void update(TypeStock typeStock);
    List<TypeStock> list();
}
