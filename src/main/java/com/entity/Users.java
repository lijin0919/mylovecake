package com.entity;

public class Users {
    private  Integer id;
    private String usernNme;
    private String password;
    private String name;
    private String phone;
    private String address;

    public Users() {
    }

    public Users(Integer id, String usernNme, String password, String name, String phone, String address) {
        this.id = id;
        this.usernNme = usernNme;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernNme() {
        return usernNme;
    }

    public void setUsernNme(String usernNme) {
        this.usernNme = usernNme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", usernNme='" + usernNme + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
