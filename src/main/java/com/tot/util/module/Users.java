package com.tot.util.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileno;
    }

    public void setmobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getQRData() {
        return QRData;
    }

    public void setQRData(String QRData) {
        this.QRData = QRData;
    }

    public Users() {
    }

    public Users(int user_id, String name, long mobileno, String QRData) {
        this.user_id = user_id;
        this.name = name;
        this.mobileno = mobileno;
        this.QRData = QRData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    private long mobileno;
    private String QRData;
}
