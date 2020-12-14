package by.teachmeskills.jdbc.dao.impl.mysql.product;

import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.dao.impl.mysql.MySqlAbstractDAO;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.dao.sql.SqlQueries;
import by.teachmeskills.jdbc.entity.field.product.ProductEntityFields;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlProductDAO extends MySqlAbstractDAO<ProductEntity> implements ProductDAO {

    @Override
    public ProductEntity create(ProductEntity entity) throws DAOException {
        return null;
    }

    @Override
    public ProductEntity getEntity(Long id) throws DAOException {
        return null;
    }

    @Override
    public List<ProductEntity> getAll() throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try(Connection connection = connectionOptional.get();
                Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(SqlQueries.SQL_READ_ALL_PRODUCTS);
                List<ProductEntity> productEntities = new ArrayList<>();
                while (resultSet.next()) {
                    final ProductEntity productEntity = processResultSet(resultSet);
                    productEntities.add(productEntity);
                }
                return productEntities;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to retrieve products");
            }
        }
        return Collections.emptyList();
    }

    @Override
    public ProductEntity updateEntity(ProductEntity entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {

    }

    @Override
    public ProductEntity getByTitle(String title) {
        return null;
    }

    private ProductEntity processResultSet(ResultSet resultSet) {
        try {
            final long id = resultSet.getLong(ProductEntityFields.ID);
            final String title = resultSet.getString(ProductEntityFields.TITLE);
            final String description = resultSet.getString(ProductEntityFields.DESCRIPTION);
            final double price = resultSet.getDouble(ProductEntityFields.PRICE);
            final long timestamp = resultSet.getLong(ProductEntityFields.TIMESTAMP);
            return new ProductEntity(id, title, description, price, timestamp);
        } catch (SQLException e) {
            LOGGER.error("Unable to parse ResultSet: {}", e.getMessage(), e);
            throw new DAOException("Unable to read product", e);
        }
    }
}
