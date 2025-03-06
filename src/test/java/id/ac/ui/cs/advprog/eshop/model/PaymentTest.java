package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        paymentData.put("voucherCode", "ESHOP123456789AB");

        payment = new Payment("1424f2b7-2af2-4b6e-a43b-a25cb252e958", order,
                "VOUCHER", "SUCCESS", paymentData);
    }

    @Test
    void testPaymentCreation() {
        assertEquals("1424f2b7-2af2-4b6e-a43b-a25cb252e958", payment.getId());
        assertEquals(order, payment.getOrder());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }

    @Test
    void testSetMethod() {
        payment.setMethod("BANK_TRANSFER");
        assertEquals("BANK_TRANSFER", payment.getMethod());
    }

    @Test
    void testSetStatus() {
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }
}
