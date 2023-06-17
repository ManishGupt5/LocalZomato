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
        return "Name : " + getName() + ",Username : " + getUsername() + ", Address : " + getAddress() + ", Email : "
                + getEmail();
    }

    public Customer(String name, String username, String password, String address, String email) {
        super(name, username, password, address, email);
    }

}