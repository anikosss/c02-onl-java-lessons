package by.teachmeskills.jdbc.dao.product;

import by.teachmeskills.jdbc.dao.DAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import java.util.Optional;

public interface ProductDAO extends DAO<ProductEntity> {

    Optional<ProductEntity> getByTitle(String title);

}
