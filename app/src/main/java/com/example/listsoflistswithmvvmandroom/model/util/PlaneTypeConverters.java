package com.example.listsoflistswithmvvmandroom.model.util;

import androidx.room.TypeConverter;

import com.example.listsoflistswithmvvmandroom.model.other.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PlaneTypeConverters {
        @TypeConverter
        public static List<Person> fromJsonStringToListOfPersons(String value) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public static String fromListOfPersonsToJsonString(List<Person> list) {
            return new Gson().toJson(list);
        }
}
