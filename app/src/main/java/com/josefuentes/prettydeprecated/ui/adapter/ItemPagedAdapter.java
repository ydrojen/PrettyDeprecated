package com.josefuentes.prettydeprecated.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import com.josefuentes.prettydeprecated.R;
import com.josefuentes.prettydeprecated.data.bd.ItemDBO;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;

public class ItemPagedAdapter extends PagedListAdapter<ItemBO, ItemViewHolder> {

  public ItemPagedAdapter() {
    super(new ItemDiffCallback());
  }

  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row__item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    ItemBO item = getItem(position);
    if (item != null) {
      holder.name.setText(item.getName());
      holder.category.setText(item.getCategory());
    }
  }
}
