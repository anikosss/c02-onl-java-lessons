package by.teachmeskills.jdbc.dao.impl.orm.product;

import by.teachmeskills.jdbc.dao.impl.orm.ORMAbstractDAO;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;

public class ProductOrmDAO extends ORMAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public ProductEntity getByTitle(String title) {
        return null;
    }
}
