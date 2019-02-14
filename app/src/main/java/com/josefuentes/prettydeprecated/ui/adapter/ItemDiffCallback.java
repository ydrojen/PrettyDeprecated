package com.josefuentes.prettydeprecated.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;

public class ItemDiffCallback extends DiffUtil.ItemCallback<ItemBO> {
  @Override
  public boolean areItemsTheSame(@NonNull ItemBO oldItem, @NonNull ItemBO newItem) {
    return oldItem.getName().equalsIgnoreCase(newItem.getName());
  }

  @Override
  public boolean areContentsTheSame(@NonNull ItemBO oldItem, @NonNull ItemBO newItem) {
    return oldItem.equals(newItem);
  }
}
