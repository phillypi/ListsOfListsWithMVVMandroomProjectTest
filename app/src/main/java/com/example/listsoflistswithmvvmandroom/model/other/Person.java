package com.example.listsoflistswithmvvmandroom.model.other;

import java.util.List;

public class Person {
    private String name;
    private List<Baggage> baggages;

    public Person(String name, List<Baggage> baggages) {
        this.name = name;
        this.baggages = baggages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Baggage> getThings() {
        return baggages;
    }

    public void setThings(List<Baggage> baggages) {
        this.baggages = baggages;
    }
}
