package com.tot.util.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Attendance {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public LocalDateTime getScantime() {
        return scantime;
    }

    public Attendance() {
    }

    public Attendance(int id, Users users, LocalDateTime scantime) {
        this.id = id;
        this.users = users;
        this.scantime = scantime;
    }

    public void setScantime(LocalDateTime scantime) {
        this.scantime = scantime;
    }

    @Id
    @GeneratedValue()
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private LocalDateTime scantime = LocalDateTime.now();
}
