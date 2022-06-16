package com.prueba.apibackend.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, length = 11) //Id único, autoincrementable
    private Integer user_id;
    @Column(name = "name", nullable = false, length = 100)
    private String user_name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String user_last_name;
    @Column(name = "email", nullable = false, length = 100)
    private String user_email;
    @Column(name = "password", nullable = false, length = 100)
    private String user_password;
    @Column(name = "age", nullable = false, length = 2)
    private Integer user_age;
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    public UserModel() {
    }

    public UserModel(Integer user_id, String user_name, String user_last_name, String user_email, String user_password, Integer user_age, String status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_age = user_age;
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_age=" + user_age +
                ", status='" + status + '\'' +
                '}';
    }
}


