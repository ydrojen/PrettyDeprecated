package com.josefuentes.prettydeprecated.data.bd;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import com.josefuentes.prettydeprecated.util.Mapper;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemDBO itemDBO = (ItemDBO) o;
    return Objects.equals(item, itemDBO.item) &&
        Objects.equals(farm_name, itemDBO.farm_name) &&
        Objects.equals(category, itemDBO.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, farm_name, category);
  }
}
