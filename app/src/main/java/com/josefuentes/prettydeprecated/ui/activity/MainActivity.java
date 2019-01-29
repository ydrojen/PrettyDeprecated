package com.josefuentes.prettydeprecated.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.josefuentes.prettydeprecated.R;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import com.josefuentes.prettydeprecated.ui.adapter.ItemAdapter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private MainViewModel viewModel;
  private RecyclerView recyclerView;
  private Observer<List<ItemBO>> itemListObserver = new Observer<List<ItemBO>>() {
    @Override
    public void onChanged(List<ItemBO> itemBOS) {
      recyclerView.setAdapter(new ItemAdapter(itemBOS));
      if(itemBOS.isEmpty()){
        viewModel.requestData();
      }
    }
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.main__list__items);

    viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    viewModel.getItemList().observe(this, itemListObserver);
  }
}
