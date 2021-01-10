package by.teachmeskills.jdbc.converter.product;

import by.teachmeskills.jdbc.converter.AbstractConverter;
import by.teachmeskills.jdbc.entity.product.ProductEntity;
import by.teachmeskills.jdbc.service.dto.ProductDTO;

public class ProductConverter extends AbstractConverter<ProductEntity, ProductDTO> {

    @Override
    public ProductDTO convert(ProductEntity entity) {
        return new ProductDTO(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getPrice());
    }
}
