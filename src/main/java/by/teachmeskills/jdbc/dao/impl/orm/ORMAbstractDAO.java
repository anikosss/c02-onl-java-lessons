package by.teachmeskills.jdbc.dao.impl.orm;

import by.teachmeskills.jdbc.dao.AbstractDAO;
import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.dao.impl.orm.session.SessionFactoryProvider;
import by.teachmeskills.jdbc.entity.IEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class ORMAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    private static final SessionFactoryProvider SESSION_FACTORY_PROVIDER = SessionFactoryProvider.getInstance();

    @Override
    public E create(E entity) throws DAOException {
        try(Session session = openSession()) {
            session.persist(entity);
            return entity;
        } catch (Exception e) {
            LOGGER.error("Unable to save entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to save entity: " + e.getMessage(), e);
        }
    }

    @Override
    public E getEntity(Long id) throws DAOException {
        try (Session session = openSession()) {
            Object product = session.get("product", id);
            return (E) product;
        } catch (Exception e) {
            LOGGER.error("Unable to load entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entity: " + e.getMessage(), e);
        }
    }

    @Override
    public List<E> getAll() throws DAOException {
        try (Session session = openSession()) {
            return session.createQuery("Select p FROM ProductEntity p").getResultList();
        } catch (Exception e) {
            LOGGER.error("Unable to load entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entities: " + e.getMessage(), e);
        }
    }

    @Override
    public E updateEntity(E entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {

    }

    private Session openSession() {
        return getSessionFactory().openSession();
    }

    private SessionFactory getSessionFactory() {
        return SESSION_FACTORY_PROVIDER.getSessionFactory();
    }

}
