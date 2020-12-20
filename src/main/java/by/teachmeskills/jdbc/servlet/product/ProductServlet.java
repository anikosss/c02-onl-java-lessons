package by.teachmeskills.jdbc.servlet.product;

import by.teachmeskills.jdbc.dao.impl.mysql.init.MySqlDAOInitializer;
import by.teachmeskills.jdbc.dao.impl.orm.init.OrmDAOInitializer;
import by.teachmeskills.jdbc.dao.init.DAOInitializer;
import by.teachmeskills.jdbc.service.dto.ProductDTO;
import by.teachmeskills.jdbc.service.product.ProductService;
import by.teachmeskills.jdbc.service.product.impl.ProductServiceImpl;
import by.teachmeskills.jdbc.servlet.page.Pages;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ProductServlet.class);
    private static final DAOInitializer MYSQl_DAO_INITIALIZER = new MySqlDAOInitializer();
    private static final DAOInitializer ORM_DAO_INITIALIZER = new OrmDAOInitializer();

    private static final String PRODUCTS_KEY = "products";

    private ProductService productService = new ProductServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
        MYSQl_DAO_INITIALIZER.init();
        ORM_DAO_INITIALIZER.init();
        LOGGER.info("Products servlet initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProductDTO> products = productService.getAllProducts();
        request.setAttribute(PRODUCTS_KEY, products);
        request.getRequestDispatcher(Pages.PRODUCTS).forward(request, response);
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}