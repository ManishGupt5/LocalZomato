package com.masai.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String password;
    private String address;
    private String email;

    public User() {
        super();
    }

    public User(String name, String password, String address, String email) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [ name=" + name + ", address=" +
                address + ", email=" + email
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, address, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User otherUser = (User) obj;
        return Objects.equals(name, otherUser.name) &&
                Objects.equals(password, otherUser.password) &&
                Objects.equals(address, otherUser.address) &&
                Objects.equals(email, otherUser.email);
    }

}
