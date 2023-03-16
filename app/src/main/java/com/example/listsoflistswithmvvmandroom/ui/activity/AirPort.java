package com.example.listsoflistswithmvvmandroom.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.listsoflistswithmvvmandroom.databinding.ActivityMainBinding;
import com.example.listsoflistswithmvvmandroom.model.other.Plane;
import com.example.listsoflistswithmvvmandroom.model.util.RecyclerItemClickListener;
import com.example.listsoflistswithmvvmandroom.ui.adapter.PlaneAdapter;
import com.example.listsoflistswithmvvmandroom.view_model.PlaneViewModel;

import java.util.List;
import java.util.Random;

public class AirPort extends AppCompatActivity {
    ActivityMainBinding binding;
    PlaneViewModel viewModel;
    PlaneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("List of List with MVVM and Room test");

        viewModel = new ViewModelProvider(this)
                .get(PlaneViewModel.class);

        viewModel.getAllPlanes().observe(this, planesList -> {
            configAdapter(viewModel.getAllPlanes().getValue());
        });

        fabListener();
        recyclerViewListener();
    }

    private void recyclerViewListener() {
        binding.activityAirPortRecyclerView
                .addOnItemTouchListener(new RecyclerItemClickListener(this,
                        binding.activityAirPortRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(),"Long click to delete",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        deleteItemOnPosition(position);
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));
    }

    private void deleteItemOnPosition(int position) {
        Plane plane = viewModel
                .getAllPlanes()
                .getValue()
                .get(position);

        Toast.makeText(getApplicationContext(),
                plane.getName()+" removed",
                Toast.LENGTH_SHORT).show();
        viewModel.delete(plane);
    }

    private void fabListener() {
        binding.activityAirPortNewPlane.setOnClickListener(v -> {
            addNewRandomPlane();
        });

    }

    private void addNewRandomPlane() {
        Random random = new Random();
        int dataBaseSize = viewModel.getAllPlanes()
                .getValue().size();

        //getting a random value between the size of list to avoid nullPointer
        int randomNumber = random
                .nextInt(dataBaseSize);

        //Getting a random "plane" from database to add test
        Plane plane = viewModel
                .getAllPlanes()
                .getValue()
                .get(randomNumber);

        //to not get a RuntimeException with id equals in room
        plane.setId(0);

        //getting a existing 'plane' from the list to save test time
        viewModel.insert(plane);
    }

    private void configAdapter(List<Plane> planes) {
            adapter = new PlaneAdapter(planes);
            binding.activityAirPortRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            binding.activityAirPortRecyclerView.setAdapter(adapter);
    }

}