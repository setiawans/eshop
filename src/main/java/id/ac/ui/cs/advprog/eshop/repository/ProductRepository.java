package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository implements IRepository<Product> {
    private List<Product> productData;

    public ProductRepository() {
        productData = new ArrayList<>();
    }

    @Override
    public Product create(Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    @Override
    public Product update(String productId, Product newProduct) {
        Product productToEdit = findById(productId);

        if (productToEdit != null) {
            productToEdit.setProductName(newProduct.getProductName());
            productToEdit.setProductQuantity(newProduct.getProductQuantity());
        }

        return productToEdit;
    }

    @Override
    public void delete(String productId) {
        Product productToDelete = findById(productId);
        productData.remove(productToDelete);
    }

    @Override
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    @Override
    public Product findById(String productId) {
        for (Product product: productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
