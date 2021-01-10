package by.teachmeskills.jdbc.dao.impl.mysql;

import by.teachmeskills.jdbc.dao.AbstractDAO;
import by.teachmeskills.jdbc.entity.IEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MySqlAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    protected static final Logger LOGGER = LogManager.getLogger(MySqlAbstractDAO.class);
    private static final String URL = "jdbc:mysql://localhost:3306/lesson27_jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "9366";


    protected Optional<Connection> getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return Optional.of(connection);
        } catch (SQLException e) {
            LOGGER.error("Unable to get JDBC connection: {}", e.getMessage(), e);
        }
        return Optional.empty();
    }

}
