package com.example.sveta.firstapplication;

public class Product
{
    private String name;
    private String price;

    public Product(String _name, String _price)
    {
        this.name=_name;
        this.price =_price;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}
