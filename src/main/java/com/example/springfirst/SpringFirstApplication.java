package com.example.springfirst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Tuple;
import java.util.Scanner;

@SpringBootApplication
public class SpringFirstApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringFirstApplication.class, args);
    }

    @Autowired
    ShopRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the shoper code:");
        int shoperCode = in.nextInt();

        Logger logger = LoggerFactory.getLogger(this.getClass());

        Shop shop1 = new Shop();
        shop1.setCode(123);
        shop1.setProduct("Mouse");
        shop1.setNumber(3);
        shop1.setPrice(5000);
        shop1.setTot_price(15000);

        repository.save(shop1);

        Shop shop2 = new Shop(123, "Mouse", 2, 10000, 20000);

        repository.save(shop2);

        Shop shop3 = new Shop();
        shop3.setCode(123);
        shop3.setProduct("Keyboard");
        shop3.setNumber(1);
        shop3.setPrice(20000);
        shop3.setTot_price(20000);

        repository.save(shop3);

        Iterable<Tuple> results = repository.findByCodeAvgTotPrice(shoperCode);

        for(Tuple p: results) {
            System.out.println("Results are:");
            System.out.println("{Product: " + p.get(0) +
                                ", Number: " + p.get(1) +
                                ", Average: " + p.get(2) +
                                ", Total price: " + p.get(3) + "}");
        }


    }
}
