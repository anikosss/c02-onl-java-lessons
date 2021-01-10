package by.teachmeskills.jdbc.dao.impl.orm.address;

import by.teachmeskills.jdbc.dao.address.AddressDAO;
import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.entity.address.AddressEntity;

public class AddressOrmDAO extends ORMAbstractDAO<AddressEntity> implements AddressDAO {

    @Override
    protected Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }
}
