package dao.impl;

import dao.TypeStockDao;
import model.TypeStock;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 27.11.16.
 */
@Repository
public class TypeStockDaoImpl extends GenericDaoImpl<TypeStock, String> implements TypeStockDao {

    public TypeStockDaoImpl() {
        super(TypeStock.class);
    }
}
