package by.teachmeskills.jdbc.dao;

import by.teachmeskills.jdbc.dao.exception.DAOException;
import by.teachmeskills.jdbc.entity.IEntity;
import java.util.List;

public interface DAO<E extends IEntity> {

    E create(E entity) throws DAOException;
    E getEntity(Long id) throws DAOException;
    List<E> getAll() throws DAOException;
    E updateEntity(E entity) throws DAOException;
    void deleteEntity(Long id) throws DAOException;

}
