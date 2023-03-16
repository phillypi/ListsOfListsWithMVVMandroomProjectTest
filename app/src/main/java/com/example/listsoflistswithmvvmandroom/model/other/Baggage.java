package com.example.listsoflistswithmvvmandroom.model.other;

public class Baggage {
    private String owner;
    private String weight;

    public Baggage(String owner, String weight) {
        this.owner = owner;
        this.weight = weight;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
