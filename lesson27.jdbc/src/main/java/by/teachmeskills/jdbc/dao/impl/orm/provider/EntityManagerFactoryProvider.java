package by.teachmeskills.jdbc.dao.impl.orm.provider;

import java.util.concurrent.locks.ReentrantLock;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static final ReentrantLock LOCK = new ReentrantLock();
    private EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryProvider() {}

    private static class EntityManagerFactoryProviderHolder {
        private static final EntityManagerFactoryProvider INSTANCE = new EntityManagerFactoryProvider();
    }

    public static EntityManagerFactoryProvider getInstance() {
        return EntityManagerFactoryProviderHolder.INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                LOCK.lock();
                init();
            } finally{
                LOCK.unlock();
            }
        }
        return entityManagerFactory;
    }

    private void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate");
    }
}
