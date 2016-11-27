package dao.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 24.11.16.
 */
@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, String> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }
}
