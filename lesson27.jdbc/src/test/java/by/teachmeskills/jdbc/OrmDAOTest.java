package by.teachmeskills.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import by.teachmeskills.jdbc.dao.impl.orm.init.OrmDAOInitializer;
import by.teachmeskills.jdbc.dao.impl.orm.product.ProductOrmDAO;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import java.util.List;
import java.util.Optional;
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

    @Test
    void testOrmDAOGetEntity() {
        final long id = 1L;
        final Optional<ProductEntity> entity = productDAO.getEntity(id);
        assertTrue(entity.isPresent());
        assertEquals(id, entity.get().getId());
    }

    @Test
    void testOrmDAOGetAll() {
        final List<ProductEntity> entities = productDAO.getAll();
        assertFalse(entities.isEmpty());
    }

    @Test
    void testOrmDAOUpdate() {
        final long id = 1L;
        Optional<ProductEntity> entityOptional = productDAO.getEntity(id);
        assertTrue(entityOptional.isPresent());

        ProductEntity entity = entityOptional.get();
        String newTitle = "new title";
        entity.setTitle(newTitle);
        ProductEntity newEntity = productDAO.updateEntity(entity);
        assertNotNull(newEntity);
        assertEquals(newTitle, newEntity.getTitle());
    }

    @Test
    void testOrmDAODelete() {
        final long id = 2L;
        Optional<ProductEntity> entity = productDAO.getEntity(id);
        assertTrue(entity.isPresent());
        productDAO.deleteEntity(id);
        entity = productDAO.getEntity(id);
        assertFalse(entity.isPresent());
    }
}
