package com.example.listsoflistswithmvvmandroom.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.listsoflistswithmvvmandroom.model.other.Plane;
import com.example.listsoflistswithmvvmandroom.model.repository.PlaneRepository;

import java.util.List;

public class PlaneViewModel extends AndroidViewModel {

    private final PlaneRepository repository;
    private final LiveData<List<Plane>> allPlanes;

    public PlaneViewModel(@NonNull Application application) {
        super(application);
        repository = new PlaneRepository(application);
        allPlanes = repository.getAllPlanes();
    }

    public void insert(Plane plane){
        repository.insert(plane);
    }

    public void update(Plane plane){
        repository.update(plane);
    }

    public void delete(Plane plane){
        repository.delete(plane);
    }

    public void deleteAllPlanes(){
        repository.deleteAllPlanes();
    }

    public LiveData<List<Plane>> getAllPlanes(){
        return allPlanes;
    }

}
