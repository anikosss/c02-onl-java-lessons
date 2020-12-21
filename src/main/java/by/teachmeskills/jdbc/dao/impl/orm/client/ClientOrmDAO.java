package by.teachmeskills.jdbc.dao.impl.orm.client;

import by.teachmeskills.jdbc.dao.client.ClientDAO;
import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.entity.client.ClientEntity;

public class ClientOrmDAO extends ORMAbstractDAO<ClientEntity> implements ClientDAO {

    @Override
    protected String getAllQuery() {
        return "FROM ClientEntity";
    }

    @Override
    protected Class<ClientEntity> getEntityClass() {
        return ClientEntity.class;
    }
}
