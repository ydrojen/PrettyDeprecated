package com.josefuentes.prettydeprecated.data.cloud;

import com.josefuentes.prettydeprecated.data.bd.ItemDBO;
import com.josefuentes.prettydeprecated.util.Mapper;

public class ItemDTO implements Mapper<ItemDBO> {
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
  public ItemDBO mapperTo() {
    ItemDBO to = new ItemDBO();
    to.setCategory(category);
    to.setFarm_name(farm_name);
    to.setItem(item);
    return to;
  }
}
