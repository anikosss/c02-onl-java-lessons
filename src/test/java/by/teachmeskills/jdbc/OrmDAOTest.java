package by.teachmeskills.jdbc;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import by.teachmeskills.jdbc.dao.impl.orm.init.OrmDAOInitializer;
import by.teachmeskills.jdbc.dao.impl.orm.product.ProductOrmDAO;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OrmDAOTest {

    private ProductDAO productDAO = new ProductOrmDAO();

    @BeforeAll
    public static void init() {
        new OrmDAOInitializer().init();
    }

    @Test
    void testOrmDAOCreate() {
        ProductEntity productEntity = productDAO.create(new ProductEntity("title", "description", 100));
        assertNotNull(productEntity);
        assertNotNull(productEntity.getId());
    }
}
