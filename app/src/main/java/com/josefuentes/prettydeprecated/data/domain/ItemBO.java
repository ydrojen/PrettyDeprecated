package com.josefuentes.prettydeprecated.data.domain;

import java.util.Objects;

public class ItemBO {
  String name;
  String farm_name;
  String category;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemBO itemBO = (ItemBO) o;
    return Objects.equals(name, itemBO.name) &&
        Objects.equals(farm_name, itemBO.farm_name) &&
        Objects.equals(category, itemBO.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, farm_name, category);
  }
}
