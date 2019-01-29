package com.josefuentes.prettydeprecated.util;

import java.util.LinkedList;
import java.util.List;

public class ListUtils {
  public static <T, E extends Mapper<T>> List<T> toMapper(List<E> sourceList){
    List<T> mappedList = new LinkedList<>();
    for (E sourceObject : sourceList) {
      mappedList.add(sourceObject.mapperTo());
    }
    return mappedList;
  }
}
