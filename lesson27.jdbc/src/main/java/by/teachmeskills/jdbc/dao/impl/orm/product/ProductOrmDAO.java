package by.teachmeskills.jdbc.dao.impl.orm.product;

import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.dao.impl.orm.query.product.ProductJPQLQueries;
import by.teachmeskills.jdbc.dao.impl.orm.util.manager.EntityManagerWrapper;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProductOrmDAO extends ORMAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public Optional<ProductEntity> getByTitle(String title) {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            TypedQuery<ProductEntity> query = entityManager.createNamedQuery(ProductJPQLQueries.GET_BY_TITLE_NAME, ProductEntity.class);
            query.setParameter("title", title);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            LOGGER.error("Unable to read product entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to get product by title", e);
        }
    }

    @Override
    protected Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }
}
