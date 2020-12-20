package by.teachmeskills.jdbc.dao.impl.orm.init;

import by.teachmeskills.jdbc.dao.impl.orm.session.SessionFactoryProvider;
import by.teachmeskills.jdbc.dao.init.DAOInitializer;

public class OrmDAOInitializer implements DAOInitializer {

    @Override
    public void init() {
        SessionFactoryProvider.getInstance().init();
    }

    @Override
    public void destroy() {

    }
}
