package com.josefuentes.prettydeprecated.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.josefuentes.prettydeprecated.R;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import com.josefuentes.prettydeprecated.ui.adapter.ItemAdapter;
import com.josefuentes.prettydeprecated.ui.adapter.ItemPagedAdapter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private final Observer<PagedList<ItemBO>> pagedListObserver = new Observer<PagedList<ItemBO>>() {
    @Override
    public void onChanged(PagedList<ItemBO> itemBOS) {
      pagedAdapter.submitList(itemBOS);
    }
  };
  private MainViewModel viewModel;
  private RecyclerView recyclerView;
  private ItemPagedAdapter pagedAdapter;
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
    //viewModel.getItemList().observe(this, itemListObserver);
    viewModel.getItemListPaged().observe(this, pagedListObserver);
    pagedAdapter = new ItemPagedAdapter();
    recyclerView.setAdapter(pagedAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if(item.getItemId() == R.id.settings){
      Intent intent = new Intent(this, SettingsActivity.class);
      startActivity(intent);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
