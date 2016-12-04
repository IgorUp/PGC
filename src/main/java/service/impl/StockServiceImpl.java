package service.impl;

import dao.StockDao;
import dao.TypeStockDao;
import model.Stock;
import model.TypeStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.StockService;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;
    @Autowired
    private TypeStockDao typeStockDao;

    @Transactional
    @Override
    public Stock get(Long id) {
        return stockDao.get(id);
    }

    @Transactional
    @Override
    public Long create(Stock stock) {
        TypeStock typeStock = typeStockDao.get(stock.getTypeStock().getId());
        stock.setTypeStock(typeStock);
        return stockDao.create(stock);
    }

    @Transactional
    @Override
    public void delete(Stock stock) {
        stockDao.delete(stock);
    }

    @Transactional
    @Override
    public void update(Stock stock) {
        TypeStock typeStock = typeStockDao.get(stock.getTypeStock().getId());
        stock.setTypeStock(typeStock);
        stockDao.update(stock);
    }

    @Transactional
    @Override
    public List<Stock> list() {
        return stockDao.findAll();
    }
}
