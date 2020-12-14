package by.teachmeskills.jdbc.dao.product;

import by.teachmeskills.jdbc.dao.DAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;

public interface ProductDAO extends DAO<ProductEntity> {

    ProductEntity getByTitle(String title);

}
