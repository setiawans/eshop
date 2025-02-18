package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("371ea840-be41-4be9-824e-3f3e371cb1f5");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(150);
    }

    @Test
    void testCreateAddProductToRepository() {
        productService.create(product);
        assertEquals(product, productService.findAll().get(0));
    }

    @Test
    void testEditWorksProperly() {
        productService.create(product);
        Product editedProduct = new Product();
        editedProduct.setProductName("Sampo Cap Asep");
        editedProduct.setProductQuantity(150);

        assertEquals(editedProduct, productService.edit("371ea840-be41-4be9-824e-3f3e371cb1f5", editedProduct));
    }

    @Test
    void testDeleteWorksProperly() {
        productService.create(product);
        productService.delete(product.getProductId());
        assertEquals(0, productService.findAll().size());
    }

    @Test
    void testFindByIdWorksProperly() {
        productService.create(product);
        assertEquals(product, productService.findById(product.getProductId()));
    }
}
