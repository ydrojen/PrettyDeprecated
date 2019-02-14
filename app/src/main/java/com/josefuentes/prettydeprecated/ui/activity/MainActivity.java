package com.josefuentes.prettydeprecated.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
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
