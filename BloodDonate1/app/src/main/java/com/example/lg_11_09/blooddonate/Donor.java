package com.example.lg_11_09.blooddonate;

/**
 * Created by LG-11-09 on 20-Jul-15.
 */
public class Donor {

    String name;
    String bg;
    String contact;

    public Donor(String name, String bg, String contact) {
        this.name = name;
        this.bg = bg;
        this.contact = contact;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
