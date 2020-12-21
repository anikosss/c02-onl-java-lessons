package by.teachmeskills.jdbc.dao.impl.orm.order.product;

import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.dao.order.product.OrderProductDAO;
import by.teachmeskills.jdbc.entity.order.product.OrderProductEntity;

public class OrderProductOrmDAO extends ORMAbstractDAO<OrderProductEntity> implements OrderProductDAO {

    @Override
    protected String getAllQuery() {
        return "FROM OrderProductEntity";
    }

    @Override
    protected Class<OrderProductEntity> getEntityClass() {
        return OrderProductEntity.class;
    }
}
