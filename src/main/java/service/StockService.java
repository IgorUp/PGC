package service;

import model.Stock;

import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
public interface StockService {
    Stock get(Long id);
    Long create(Stock stock);
    void delete(Stock stock);
    void update(Stock stock);
    List<Stock> list();
}
