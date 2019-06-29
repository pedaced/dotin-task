package com.example.springfirst;

import javax.persistence.*;

@Entity
@Table(name="shop")
public class Shop {

    public Shop() {
    }

    public Shop(int code, String product, int number, int price, int tot_price) {
        this.code = code;
        this.product = product;
        this.number = number;
        this.price = price;
        this.tot_price = tot_price;
    }

    @Id
    @GeneratedValue
    int id;

    @Column(name="code")
    int code;

    @Column(name="product")
    String product;

    @Column(name="number")
    int number;

    @Column(name="price")
    int price;

    @Column(name="tot_price")
    int tot_price;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getNumeber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTot_price() {
        return this.tot_price;
    }

    public void setTot_price(int tot_price) {
        this.tot_price = tot_price;
    }

}

