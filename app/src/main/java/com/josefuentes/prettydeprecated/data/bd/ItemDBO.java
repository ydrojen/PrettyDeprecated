package com.josefuentes.prettydeprecated.data.bd;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import com.josefuentes.prettydeprecated.util.Mapper;

@Entity(tableName = "items")
public class ItemDBO implements Mapper<ItemBO> {

  @PrimaryKey
  @NonNull
  String item;
  String farm_name;
  String category;

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getFarm_name() {
    return farm_name;
  }

  public void setFarm_name(String farm_name) {
    this.farm_name = farm_name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public ItemBO mapperTo() {
    ItemBO to = new ItemBO();
    to.setCategory(category);
    to.setFarm_name(farm_name);
    to.setName(item);
    return to;
  }
}
