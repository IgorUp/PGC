package dao.impl;

import dao.StockDao;
import model.Stock;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 27.11.16.
 */
@Repository
public class StockDaoImpl extends GenericDaoImpl<Stock, Long> implements StockDao {

    public StockDaoImpl() {
        super(Stock.class);
    }
}
