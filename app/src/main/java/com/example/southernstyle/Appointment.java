package com.example.southernstyle;

public class Appointment {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String date;
    private String time;

    public Appointment() {
        //default for firebase
    }

    public Appointment(String id, String name, String email, String phone, String date, String time) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
