package com.masai.entities;

import java.util.Objects;

public class FoodItem implements Comparable<FoodItem> {
    public int id;
    public String catagory;
    public String name;
    public int price;

    public FoodItem(int id, String catagory, String name, int price) {
        this.id = id;
        this.catagory = catagory;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItem [id=" + id + ", catagory=" + catagory + ", name=" + name + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catagory, name, price);
    }

    @Override
    public int compareTo(FoodItem b) {
        FoodItem a = this;
        if (b == a) {
            return 0;
        } else if (b.price > a.price) {
            return 1;
        } else {
            return -1;
        }
    }
}