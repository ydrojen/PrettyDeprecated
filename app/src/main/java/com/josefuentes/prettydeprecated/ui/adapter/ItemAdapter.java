package com.josefuentes.prettydeprecated.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.josefuentes.prettydeprecated.R;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

  private List<ItemBO> data;

  public ItemAdapter(List<ItemBO> data) {
    this.data = data;
  }

  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row__item, parent, false);
    return new ItemViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    ItemBO item = data.get(position);
    holder.name.setText(item.getName());
    holder.category.setText(item.getCategory());
  }

  @Override
  public int getItemCount() {
    return data.size();
  }
}
