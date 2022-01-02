package com.website.website.service;

import com.website.website.model.Product;
import com.website.website.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product p1 = new Product(1,"Air Jordan 1 Mid","Men","This is the classic airJordan 1",130,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/7f6e14bc-ad90-46ef-aac3-0f63b0fcfe3d/chaussure-air-jordan-1-mid-pour-hP1DJJ.png",20);
            Product p2 = new Product(2,"Air Force 1","Men","This is the classic air force one",110,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4f37fca8-6bce-43e7-ad07-f57ae3c13142/chaussure-air-force-1-07-pour-lKPQ6q.png",20);
            Product p3 = new Product(3,"Nike Air Max 97","Men","This is the classic nike air max 97",180,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/719096c6-2bd2-4673-a232-88be8e0d4f58/chaussure-air-max-97-pour-Bc9BgR.png",20);
            Product p4 = new Product(4,"Nike Air Max 95","Men","This is the classic nike air max 95",180,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/39ea0eb4-02ae-480e-964f-e047f870cc7e/chaussures-air-max-95-DCS600.png",20);
            Product p5 = new Product(5,"Nike React Vision","Men","This is the classic nike react vision",130,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b752c191-7cb2-42fb-ba70-0ffd780e8081/chaussure-react-vision-pour-cMXQnH.png",20);
            Product p6 = new Product(6,"Nike Air Max Plus","Men","This is the classic nike air max plus",170,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/0ff7e157-bf3a-4e13-97c0-1157789ed25a/chaussures-air-max-plus-pour-8FvzV9.png",20);
            Product p7 = new Product(7,"Nike Air Force 1 '07","Women","This is the classic nike air force 1 '07",130,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/53a84a35-e772-45ce-b011-8d2645d394bf/chaussures-air-force-1-07-pour-L8NbRw.png",20);
            Product p8 = new Product(8,"Nike Air More Uptempo","Women","This is the classic nike air more uptempo",160,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4e93d193-e600-4280-a28c-baf31511417d/chaussure-air-more-uptempo-pour-1VgdC7.png",20);
            Product p9 = new Product(9,"Nike Air Max 95","Women","This is the classic nike air max 95",170,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/ac31f7b6-e1ea-466d-9457-e9ff9d8a1b6a/chaussure-air-max-95-pour-Rxll89.png",20);
            Product p10 = new Product(10,"Nike Air Max Plus","Women","This is the classic nike air max plus",170,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b092dce3-2127-44cd-924d-3383cf287f09/chaussure-air-max-plus-pour-nqvV6X.png",20);
            Product p11 = new Product(11,"Nike Air Jordan 1 Mid","Women","This is the classic nike air jordan 1 mid",120,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/fa88faea-46b2-4683-aedd-d3d2fb4c0ba7/chaussure-air-jordan-1-mid-pour-Ct9zLk.png",20);
            Product p12 = new Product(12,"Nike Air Max 270 G","Women","This is the classic nike air max 270 g",150,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/19748bd0-5a80-4583-9c3f-e29a24044a58/chaussure-de-golf-air-max-270-g-v2sXd5.png",20);

            productRepository.saveAll(List.of(p1, p2, p3, p4,p5,p6,p7,p8,p9,p10,p11,p12));
        };
    }
}

