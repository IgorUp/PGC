package service.impl;

import dao.ProductDao;
import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductService;
import service.UserService;

import java.util.List;

/**
 * Created by igor on 24.11.16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Product get(String id) {
        return productDao.get(id);
    }

    @Transactional
    @Override
    public String create(Product product) {
        User user = userService.get(product.getIdUser());
        product.setUser(user);
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
        User user = userService.get(product.getIdUser());
        product.setUser(user);
        productDao.update(product);
    }

    @Transactional
    @Override
    public List<Product> list() {
        return productDao.findAll();
    }
}
