package com.josefuentes.prettydeprecated.data.bd;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ItemsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ItemDBO> itemsList);

  @Query("SELECT * FROM items")
  LiveData<List<ItemDBO>> getAll();

  @Query("SELECT * FROM items")
  DataSource.Factory<Integer, ItemDBO> getAllPaged();

    @Query("SELECT * FROM items LIMIT :limit OFFSET :offset")
    LiveData<List<ItemDBO>> getAll(int limit, int offset);

}