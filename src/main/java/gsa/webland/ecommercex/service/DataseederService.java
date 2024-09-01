package gsa.webland.ecommercex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import gsa.webland.ecommercex.model.Product;
import gsa.webland.ecommercex.model.User;
import gsa.webland.ecommercex.repository.ProductRepository;
import gsa.webland.ecommercex.repository.UserRepository;

@Service
public class DataseederService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository  productRepository;
    
    private final Faker faker = new Faker();

    public void createUser() {
        for (int i = 0; i < 10; i++) {
            User jeff = User.builder()
                    .email(faker.internet().emailAddress())
                    .password(faker.internet().password())
                    .username(faker.name().username())
                    .build();

            userRepository.save(jeff);

        }
    }


    public void createProduct() {
        for (int i = 0; i < 10; i++) {
            Product p = Product.builder()
            .price(faker.random().nextDouble()*1000)
            .name(faker.funnyName().name())
            .description(faker.lorem().paragraph())
            .build();

            productRepository.save(p);
                   
        
        }
    }

}
