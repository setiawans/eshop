package id.ac.ui.cs.advprog.eshop.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

@AutoConfigureJsonTesters
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<Product> jsonProduct;

    @MockBean
    private ProductService productService;

    Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("371ea840-be41-4be9-824e-3f3e371cb1f5");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(150);
    }

    @Test
    void canGetCreateProduct() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/product/create")
        ).andReturn().getResponse();
        assert (response.getStatus() == HttpStatus.SC_OK);
    }

    @Test
    void canPostCreateProduct() throws Exception {
        String json = jsonProduct.write(product).getJson();
        MockHttpServletResponse response = mockMvc.perform(
                post("/product/create")
                        .contentType("application/json")
                        .content(json != null ? json : "")
        ).andReturn().getResponse();

        assert (response.getStatus() == HttpStatus.SC_MOVED_TEMPORARILY);
    }

    @Test
    void canGetEditProduct() throws Exception {
        String json = jsonProduct.write(product).getJson();
        mockMvc.perform(
                post("/product/create")
                        .contentType("application/json")
                        .content(json != null ? json : "")
        ).andReturn().getResponse();

        Mockito.when(productService.findById(product.getProductId())).thenReturn(product);

        MockHttpServletResponse response = mockMvc.perform(
                get("/product/edit/" + product.getProductId())
        ).andReturn().getResponse();

        assert (response.getStatus() == HttpStatus.SC_OK);
    }

    @Test
    void canPostEditProduct() throws Exception {
        String jsonExistProduct = jsonProduct.write(product).getJson();
        mockMvc.perform(
                post("/product/create")
                        .contentType("application/json")
                        .content(jsonExistProduct != null ? jsonExistProduct : "")
        ).andReturn().getResponse();

        Product updatedProduct = new Product();
        updatedProduct.setProductId(product.getProductId());
        updatedProduct.setProductName("Sampo Cap Mamang");
        updatedProduct.setProductQuantity(150);

        String json = jsonProduct.write(updatedProduct).getJson();
        MockHttpServletResponse response = mockMvc.perform(
                post("/product/edit/" + product.getProductId())
                        .contentType("application/json")
                        .content(json != null ? json : "")
        ).andReturn().getResponse();

        assert (response.getStatus() == HttpStatus.SC_MOVED_TEMPORARILY);
    }

    @Test
    void canRedirectWhenEditFails() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/product/edit/f8a3b140-0f1a-49ee-9d52-c59caa5ab647")
        ).andReturn().getResponse();

        assert(response.getStatus() == HttpStatus.SC_MOVED_TEMPORARILY);
    }

    @Test
    void canDeleteProduct() throws Exception {
        String json = jsonProduct.write(product).getJson();

        mockMvc.perform(
                post("/product/create")
                        .contentType("application/json")
                        .content(json != null ? json : "")
        ).andReturn().getResponse();

        MockHttpServletResponse response = mockMvc.perform(
                post("/product/delete/" + product.getProductId())
        ).andReturn().getResponse();

        assert (response.getStatus() == HttpStatus.SC_MOVED_TEMPORARILY);
    }

    @Test
    void canGetProductList() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/product/list")
        ).andReturn().getResponse();

        assert (response.getStatus() == HttpStatus.SC_OK);
    }
}
