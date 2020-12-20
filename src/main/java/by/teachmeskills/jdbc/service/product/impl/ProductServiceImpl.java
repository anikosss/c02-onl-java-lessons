package by.teachmeskills.jdbc.service.product.impl;

import by.teachmeskills.jdbc.converter.IConverter;
import by.teachmeskills.jdbc.converter.product.ProductConverter;
import by.teachmeskills.jdbc.dao.impl.orm.product.ProductOrmDAO;
import by.teachmeskills.jdbc.dao.product.ProductDAO;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import by.teachmeskills.jdbc.service.dto.ProductDTO;
import by.teachmeskills.jdbc.service.product.ProductService;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductOrmDAO();
    private IConverter<ProductEntity, ProductDTO> converter = new ProductConverter();

    @Override
    public List<ProductDTO> getAllProducts() {
        return converter.convertAll(productDAO.getAll());
    }
}
