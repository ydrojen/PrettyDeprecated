package com.josefuentes.prettydeprecated.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.josefuentes.prettydeprecated.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

  TextView name;

  public ItemViewHolder(@NonNull View itemView) {
    super(itemView);
    name = itemView.findViewById(R.id.main_list__label__name);
  }
}
