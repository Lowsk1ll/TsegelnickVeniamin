package ru.training.at.hw7jdi.entities;

public enum HeaderMenu {
    Home("Home"),
    ContactForm("Contact form"),
    Service("Service"),
    MetalsColors("Metals & Colors");

    public String value;

    HeaderMenu(String value) {
        this.value = value;
    }
}
