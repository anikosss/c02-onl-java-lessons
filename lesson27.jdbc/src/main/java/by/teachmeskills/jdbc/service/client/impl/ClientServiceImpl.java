package by.teachmeskills.jdbc.service.client.impl;

import by.teachmeskills.jdbc.dao.client.ClientDAO;
import by.teachmeskills.jdbc.dao.impl.orm.client.ClientOrmDAO;
import by.teachmeskills.jdbc.entity.client.ClientEntity;
import by.teachmeskills.jdbc.service.client.ClientService;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new ClientOrmDAO();

    @Override
    public List<ClientEntity> getAll() {
        return clientDAO.getAll();
    }
}
