package com.webservice.toweb.config;

import com.webservice.toweb.entities.*;
import com.webservice.toweb.enums.OrderSatatus;
import com.webservice.toweb.repositories.*;
import org.hibernate.boot.model.relational.ColumnOrderingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final Orderrepository orderrepository;
    private final CatgoryRepository catgoryRepository;
    private final ProductRepository productRepository;
    private final OrderItemRespository orderItemRespository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, Orderrepository orderrepository, CatgoryRepository catgoryRepository, ProductRepository productRepository, OrderItemRespository orderItemRespository, PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.orderrepository = orderrepository;
        this.catgoryRepository = catgoryRepository;
        this.productRepository = productRepository;
        this.orderItemRespository = orderItemRespository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //add users in database =================================
        User user_ = new User(null, "Maria Db", "maria@gmail.com", "33063306", "80808080");
        User user__ = new User(null, "Cauã Pires", "caua@gmail.com", "9939396", "67876543");

        //add orders in database references users ===============
        Order order_ = new Order(null, Instant.now(), user_, OrderSatatus.PAID);
        Order order__ = new Order(null, Instant.now(), user__, OrderSatatus.DELIVERED);
        Order order___ = new Order(null, Instant.now(), user_, OrderSatatus.SHIPPED);

        //add categories in database ============================
        Category category_ = new Category(null, "Eletronic");
        Category category__ = new Category(null, "Games");
        Category category___ = new Category(null, "ColdItens");

        //add products in database reference category ============
        Product product_ = new Product(null, "Cell", "use ever time", 1200.00, "http://img01.png");
        Product product__ = new Product(null, "Frezer", "is very cold", 5500.00, "http://img02.png");
        Product product___ = new Product(null, "Desktop", "play any games if you want", 6200.00, "http://img03.png");

        OrderItem oi1 = new OrderItem(order_, product_, 2, product___.getPrice());
        OrderItem oi2 = new OrderItem(order__, product___, 1, product_.getPrice());
        OrderItem oi3 = new OrderItem(order___, product__, 2, product__.getPrice());
        OrderItem oi4 = new OrderItem(order__, product__, 2, product__.getPrice());

        product_.getCategories().add(category_);
        product_.getCategories().add(category__);
        product__.getCategories().add(category___);
        product___.getCategories().add(category__);
        product___.getCategories().add(category_);

        Payment payment_ = new Payment(null, LocalDate.parse("2024-09-01"), order_);
        Payment payment__ = new Payment(null, LocalDate.parse("2020-11-21"), order__);

        order_.setPayment(payment_);
        order__.setPayment(payment__);

        //set all items in the h2 database
        userRepository.saveAll(Arrays.asList(user_, user__));
        orderrepository.saveAll(Arrays.asList(order_, order__, order___));
        catgoryRepository.saveAll(Arrays.asList(category_, category__, category___));
        productRepository.saveAll(Arrays.asList(product_, product__, product___));
        orderItemRespository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
