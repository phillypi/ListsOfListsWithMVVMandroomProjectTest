package com.example.listsoflistswithmvvmandroom.model.other;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.listsoflistswithmvvmandroom.model.util.PlaneTypeConverters;

import java.util.List;

@Entity(tableName = "plane_table")
@TypeConverters(PlaneTypeConverters.class)
public class Plane {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private List<Person> listOfEconomicPassengers;
    private List<Person> listOfFirstClassPassengers;
    private boolean isFlying;

    public Plane(String name,List<Person> listOfEconomicPassengers,
                 List<Person> listOfFirstClassPassengers, boolean isFlying) {
        this.listOfEconomicPassengers = listOfEconomicPassengers;
        this.listOfFirstClassPassengers = listOfFirstClassPassengers;
        this.isFlying = isFlying;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getListOfEconomicPassengers() {
        return listOfEconomicPassengers;
    }

    public void setListOfEconomicPassengers(List<Person> listOfEconomicPassengers) {
        this.listOfEconomicPassengers = listOfEconomicPassengers;
    }

    public List<Person> getListOfFirstClassPassengers() {
        return listOfFirstClassPassengers;
    }

    public void setListOfFirstClassPassengers(List<Person> listOfFirstClassPassengers) {
        this.listOfFirstClassPassengers = listOfFirstClassPassengers;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        this.isFlying = flying;
    }
}
