package by.teachmeskills.jdbc.dao.impl.orm.order;

import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.dao.order.OrderDAO;
import by.teachmeskills.jdbc.entity.order.OrderEntity;

public class OrderOrmDAO extends ORMAbstractDAO<OrderEntity> implements OrderDAO {

    @Override
    protected Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}
