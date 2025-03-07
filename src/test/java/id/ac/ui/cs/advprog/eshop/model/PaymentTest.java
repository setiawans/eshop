package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Payment payment;
    private Order order;
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("1b709a33-4da3-4cbd-abd1-dc4dd3d855eb");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);

        order = new Order("c564148a-a11f-4865-9744-60ade538c37b", products,
                System.currentTimeMillis(), "Steven", OrderStatus.WAITING_PAYMENT.getValue());

        paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP12345678ABC");

        payment = new Payment(UUID.randomUUID().toString(), order, PaymentMethod.VOUCHER.getValue(), paymentData);
    }

    @Test
    void testPaymentCreation() {
        assertEquals(order, payment.getOrder());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testSetOrder() {
        List<Product> newProducts = new ArrayList<>();
        Product newProduct = new Product();
        newProduct.setProductId("new-product-id");
        newProduct.setProductName("New Product");
        newProduct.setProductQuantity(1);
        newProducts.add(newProduct);

        Order newOrder = new Order("new-order-id", newProducts,
                System.currentTimeMillis(), "Setiawan", OrderStatus.WAITING_PAYMENT.getValue());

        payment.setOrder(newOrder);
        assertEquals(newOrder, payment.getOrder());
        assertNotEquals(order, payment.getOrder());
    }

    @Test
    void testSetMethod() {
        payment.setMethod(PaymentMethod.TRANSFER_BANK.getValue());
        assertEquals(PaymentMethod.TRANSFER_BANK.getValue(), payment.getMethod());
    }

    @Test
    void testSetStatus() {
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

}
