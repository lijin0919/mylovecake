package com.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer total;
    private Integer amount;
    private  byte status;
    private byte paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private  Integer userId;

    public Order() {
    }

    public Order(Integer id, Integer total, Integer amount, byte status, byte paytype, String name, String phone, String address, Date systime, Integer userId) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.status = status;
        this.paytype = paytype;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.systime = systime;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getPaytype() {
        return paytype;
    }

    public void setPaytype(byte paytype) {
        this.paytype = paytype;
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

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", amount=" + amount +
                ", status=" + status +
                ", paytype=" + paytype +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", systime=" + systime +
                ", userId=" + userId +
                '}';
    }
}
