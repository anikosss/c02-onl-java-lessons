package by.teachmeskills.jdbc.dao.impl.orm;

import by.teachmeskills.jdbc.dao.AbstractDAO;
import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.dao.impl.orm.provider.EntityManagerFactoryProvider;
import by.teachmeskills.jdbc.dao.impl.orm.util.manager.EntityManagerWrapper;
import by.teachmeskills.jdbc.entity.IEntity;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@SuppressWarnings("unchecked")
public abstract class ORMAbstractDAO<E extends IEntity> extends AbstractDAO<E> {

    private static final EntityManagerFactoryProvider ENTITY_MANAGER_FACTORY_PROVIDER = EntityManagerFactoryProvider.getInstance();

    @Override
    public E create(E entity) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            entityManager.persist(entity);
            entityManager.refresh(entity);
            return entity;
        } catch (Exception e) {
            LOGGER.error("Unable to save entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to save entity: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<E> getEntity(Long id) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            return Optional.ofNullable(entityManager.find(getEntityClass(), id));
        } catch (Exception e) {
            LOGGER.error("Unable to load entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entity: " + e.getMessage(), e);
        }
    }

    @Override
    public List<E> getAll() throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
            return entityManager.createQuery(criteria.select(criteria.from(getEntityClass()))).getResultList();
        } catch (Exception e) {
            LOGGER.error("Unable to load entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to load entities: " + e.getMessage(), e);
        }
    }

    @Override
    public E updateEntity(E entity) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            return entityManager.merge(entity);
        } catch (Exception e) {
            LOGGER.error("Unable to update entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to update entity: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            Optional<E> entityOptional = getEntity(id);
            entityOptional.ifPresent(entityManager::remove);
        } catch (Exception e) {
            LOGGER.error("Unable to delete entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to delete entity: " + e.getMessage(), e);
        }
    }

    protected abstract Class<E> getEntityClass();


    protected EntityManagerWrapper getEntityManagerWrapper() {
        return new EntityManagerWrapper(ENTITY_MANAGER_FACTORY_PROVIDER.getEntityManagerFactory().createEntityManager());
    }

}
