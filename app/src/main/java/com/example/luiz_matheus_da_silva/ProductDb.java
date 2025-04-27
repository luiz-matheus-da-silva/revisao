package com.example.luiz_matheus_da_silva;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDb extends RoomDatabase {
    private static ProductDb instance;

    public abstract ProductDao productDao();

    public static synchronized ProductDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProductDb.class,
                            "product-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}
