package service.impl;

import dao.ProductDao;
import dao.TypeStockDao;
import model.Product;
import model.TypeStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductService;
import service.TypeStockService;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Service
public class TypeStockServiceImpl implements TypeStockService {

    @Autowired
    private TypeStockDao typeStockDao;
    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public TypeStock get(String id) {
        return typeStockDao.get(id);
    }

    @Transactional
    @Override
    public String create(TypeStock typeStock) {
        return typeStockDao.create(typeStock);
    }

    @Transactional
    @Override
    public void delete(TypeStock typeStock) {
        typeStockDao.delete(typeStock);
    }

    @Transactional
    @Override
    public void update(TypeStock typeStock) {
        typeStockDao.update(typeStock);
    }

    @Transactional
    @Override
    public List<TypeStock> list() {
        return typeStockDao.findAll();
    }
}
