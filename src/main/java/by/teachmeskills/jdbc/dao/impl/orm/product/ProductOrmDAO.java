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
    public Optional<ProductEntity> getByTitle(String title) {
        try (Session session = openSession()) {
            Query<ProductEntity> query = session.createQuery(ProductHQLQueries.GET_BY_TITLE, getEntityClass());
            query.setParameter(ProductEntityFields.TITLE, title);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            LOGGER.error("Unable to read product entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to get product by title", e);
        }
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
