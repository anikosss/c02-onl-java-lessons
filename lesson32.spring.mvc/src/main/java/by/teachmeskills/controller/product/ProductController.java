package by.teachmeskills.controller.product;

import by.teachmeskills.dao.product.ProductDAO;
import by.teachmeskills.entity.product.ProductEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductDAO productDAO;

    @GetMapping
    public ModelAndView products() {
        return new ModelAndView("products", "products", productDAO.getAll());
    }

    @ModelAttribute("products")
    public List<ProductEntity> getProducts() {
        return productDAO.getAll();
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
