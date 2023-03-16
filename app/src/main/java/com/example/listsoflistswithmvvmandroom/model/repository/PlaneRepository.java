package com.example.listsoflistswithmvvmandroom.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.listsoflistswithmvvmandroom.model.dao.PlaneDao;
import com.example.listsoflistswithmvvmandroom.model.database.PlaneDataBase;
import com.example.listsoflistswithmvvmandroom.model.other.Plane;

import java.util.List;

public class PlaneRepository {


    private PlaneDao planeDao;
    private LiveData<List<Plane>> allPlanes;

    public PlaneRepository(Application application) {
        PlaneDataBase database = PlaneDataBase.getInstance(application);
        planeDao = database.planeDao();
        this.allPlanes = planeDao.getAllPlanes();
    }

    public void insert(Plane plane) {
        new InsertPlaneAsyncTask(planeDao).execute(plane);
    }

    public void update(Plane plane) {
        new UpdatePlaneAsyncTask(planeDao).execute(plane);
    }

    public void delete(Plane plane) {
        new DeletePlaneAsyncTask(planeDao).execute(plane);
    }

    public void deleteAllPlanes() {
        new DeleteAllPlanesAsyncTask(planeDao).execute();
    }

    public LiveData<List<Plane>> getAllPlanes() {
        return allPlanes;
    }

    private static class InsertPlaneAsyncTask extends AsyncTask<Plane, Void, Void> {
        private final PlaneDao planeDao;

        private InsertPlaneAsyncTask(PlaneDao planeDao) {
            this.planeDao = planeDao;
        }

        @Override
        protected Void doInBackground(Plane... planes) {
            planeDao.insert(planes[0]);
            return null;
        }
    }

    private static class UpdatePlaneAsyncTask extends AsyncTask<Plane, Void, Void> {
        private PlaneDao planeDao;

        private UpdatePlaneAsyncTask(PlaneDao planeDao) {
            this.planeDao = planeDao;
        }

        @Override
        protected Void doInBackground(Plane... planes) {
            planeDao.update(planes[0]);
            return null;
        }
    }

    private static class DeletePlaneAsyncTask extends AsyncTask<Plane, Void, Void> {
        private PlaneDao planeDao;

        private DeletePlaneAsyncTask(PlaneDao planeDao) {
            this.planeDao = planeDao;
        }

        @Override
        protected Void doInBackground(Plane... planes) {
            planeDao.delete(planes[0]);
            return null;
        }
    }
    private static class DeleteAllPlanesAsyncTask extends AsyncTask<Void, Void, Void> {
        private PlaneDao planeDao;

        private DeleteAllPlanesAsyncTask(PlaneDao planeDao) {
            this.planeDao = planeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            planeDao.deleteAll();
            return null;
        }
    }




}
