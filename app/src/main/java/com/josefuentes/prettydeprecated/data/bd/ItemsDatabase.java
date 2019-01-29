package com.josefuentes.prettydeprecated.data.bd;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = { ItemDBO.class }, version = 1, exportSchema = false)
public abstract class ItemsDatabase extends RoomDatabase {

  private static ItemsDatabase INSTANCE;

  public static ItemsDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (ItemsDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ItemsDatabase.class, "DB_items")
              .build();
        }
      }
    }

    return INSTANCE;
  }

  public abstract ItemsDAO itemsDAO();
}