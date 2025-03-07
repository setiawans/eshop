package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.ui.Model;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.OrderService;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/create")
    public String createOrderPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "CreateOrder";
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam String authorName,
                              @RequestParam List<String> products) {

        List<Product> productList = new ArrayList<>();
        for (String product : products) {
            productList.add(productService.findById(product));
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                productList,
                Instant.now().toEpochMilli(),
                authorName
        );

        Order savedOrder = orderService.createOrder(order);
        return "redirect:/order/pay/" + savedOrder.getId();
    }

    @GetMapping("/history")
    public String orderHistoryPage(@RequestParam(value = "author", required = false) String authorName,
                                   Model model) {
        if (authorName != null && !authorName.isEmpty()) {
            List<Order> orders = orderService.findAllByAuthor(authorName);
            model.addAttribute("orders", orders);
        }

        return "OrderHistoryForm";
    }

    @PostMapping("/history")
    public String orderHistoryPost(@RequestParam("author")  String authorName,
                                   Model model) {
        List<Order> orders = orderService.findAllByAuthor(authorName);
        model.addAttribute("orders", orders);
        return "OrderHistory";
    }

    @GetMapping("/pay/{orderId}")
    public String payPage(@PathVariable String orderId, Model model) {
        Order order = orderService.findById(orderId);
        model.addAttribute("order", order);
        return "OrderPayment";
    }

    @PostMapping("/pay/{orderId}")
    public String payPost(@PathVariable String orderId,
                          @RequestParam String paymentMethod,
                          @RequestParam(required = false) String voucherCode,
                          @RequestParam(required = false) String bankName,
                          @RequestParam(required = false) String referenceCode,
                          Model model) {
        Order order = orderService.findById(orderId);

        if (order == null) {
            return "redirect:/order/history";
        }
        Map<String, String> paymentData = new HashMap<>();

        if (paymentMethod.equals(PaymentMethod.VOUCHER.getValue())) {
            paymentData.put("voucherCode", voucherCode);
        } else if (paymentMethod.equals(PaymentMethod.TRANSFER_BANK.getValue())) {
            paymentData.put("bankName", bankName);
            paymentData.put("referenceCode", referenceCode);
        }

        Payment payment = paymentService.addPayment(order, paymentMethod, paymentData);
        return "redirect:/order/history";
    }
}
