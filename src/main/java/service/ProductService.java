package service;


import model.Product;

import java.util.List;

/**
 * Created by igor on 24.11.16.
 */
public interface ProductService {

    Product get(String id);
    String create(Product product);
    void delete(Product product);
    void update(Product product);
    List<Product> list();

}
