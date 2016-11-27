package dao.impl;

import dao.TypeTransportDao;
import model.TypeTransport;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 27.11.16.
 */
@Repository
public class TypeTransportDaoImpl extends GenericDaoImpl<TypeTransport, Long> implements TypeTransportDao
{

    public TypeTransportDaoImpl() {
        super(TypeTransport.class);
    }
}
