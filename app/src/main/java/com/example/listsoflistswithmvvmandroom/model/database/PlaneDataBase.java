package com.example.listsoflistswithmvvmandroom.model.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.listsoflistswithmvvmandroom.model.dao.PlaneDao;
import com.example.listsoflistswithmvvmandroom.model.other.Baggage;
import com.example.listsoflistswithmvvmandroom.model.other.Person;
import com.example.listsoflistswithmvvmandroom.model.other.Plane;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Plane.class}, version = 1)
public abstract class PlaneDataBase extends RoomDatabase {
    private static PlaneDataBase instance;

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static synchronized PlaneDataBase getInstance(Context context) {
        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                            PlaneDataBase.class, "plane_database")
                    //.fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    public abstract PlaneDao planeDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private final PlaneDao planeDao;

        private PopulateDbAsyncTask(PlaneDataBase db) {
            planeDao = db.planeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
           //ADD NEW LIST OF
            List<Person> people = new ArrayList<>();
            List<Baggage> baggages = new ArrayList<>();
            List<Plane> planes = new ArrayList<>();

            baggages.add(new Baggage("Phillypi Fernandes", "25kg"));
            baggages.add(new Baggage("Phillypi Fernandes", "15kg"));

            people.add(new Person("Phillypi Fernandes", baggages));

            baggages.add(new Baggage("Jailton Mendes", "8kg"));
            people.add(new Person("Jailton Mendes", baggages));

            planeDao.insert(new Plane("Boeing 737", people,
                    null, false));

            planeDao.insert(new Plane("ATR 72-500", people,
                    null, false));

            planeDao.insert(new Plane("ATR 72-600", people,
                    null, false));

            planeDao.insert(new Plane("Embraer 195", people,
                    null, false));

            planeDao.insert(new Plane("Boeing 737-700", people,
                    null, false));

            planeDao.insert(new Plane("Airbus A319", people,
                    null, false));

            planeDao.insert(new Plane("Embraer 195 E-2", people,
                    null, false));

            return null;
        }
    }
}
