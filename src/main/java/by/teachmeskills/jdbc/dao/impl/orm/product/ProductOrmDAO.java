package by.teachmeskills.jdbc.dao.impl.orm.product;

import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.dao.impl.orm.query.product.ProductHQLQueries;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.field.product.ProductEntityFields;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProductOrmDAO extends ORMAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public ProductEntity getByTitle(String title) {
        return null;
    }

    @Override
    protected String getAllQuery() {
        return ProductHQLQueries.GET_ALL;
    }

    @Override
    protected Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }
}
