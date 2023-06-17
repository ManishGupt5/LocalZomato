package com.masai.entities;

public class Customer extends User {

    void changePassword(String password) {
        setPassword(password);
    }

    void changeAddress(String add) {
        setAddress(add);
    }

    void updateEmail(String email) {
        setEmail(email);
    }

    @Override
    public String toString() {
        return "Name : " + getName() + ", Address : " + getAddress() + ", Email : "
                + getEmail();
    }

    public Customer(String name, String password, String address, String email) {
        super(name, password, address, email);
    }

}