package service.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductService;

import java.util.List;

/**
 * Created by igor on 24.11.16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Product get(Long id) {
        return productDao.get(id);
    }

    @Transactional
    @Override
    public Long create(Product product) {
        return productDao.create(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Transactional
    @Override
    public List<Product> list() {
        return productDao.findAll();
    }
}
