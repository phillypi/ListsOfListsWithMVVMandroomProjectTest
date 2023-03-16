package com.example.listsoflistswithmvvmandroom.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.listsoflistswithmvvmandroom.model.other.Plane;

import java.util.List;
@Dao
public interface PlaneDao {
    @Insert
    void insert(Plane plane);

    @Update
    void update(Plane plane);

    @Delete
    void delete(Plane plane);

    @Query("DELETE FROM plane_table")
    void deleteAll();

    @Query("SELECT * FROM plane_table")
    LiveData<List<Plane>> getAllPlanes();
}
