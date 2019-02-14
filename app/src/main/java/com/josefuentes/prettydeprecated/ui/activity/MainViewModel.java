package com.josefuentes.prettydeprecated.ui.activity;

import android.app.Application;
import android.app.job.JobInfo;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.josefuentes.prettydeprecated.data.bd.ItemDBO;
import com.josefuentes.prettydeprecated.data.bd.ItemsDatabase;
import com.josefuentes.prettydeprecated.data.domain.ItemBO;
import com.josefuentes.prettydeprecated.task.ApiJob;
import com.josefuentes.prettydeprecated.task.JobExecutor;
import com.josefuentes.prettydeprecated.task.jobs.DownloadItemsJob;
import com.josefuentes.prettydeprecated.util.ListUtils;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

  private final LiveData<List<ItemBO>> itemList;
  private final LiveData<PagedList<ItemBO>> itemPagedList;

  public MainViewModel(@NonNull Application application) {
    super(application);
    itemList = Transformations.map(ItemsDatabase.getDatabase(application).itemsDAO().getAll(),
        new Function<List<ItemDBO>, List<ItemBO>>() {
          @Override
          public List<ItemBO> apply(List<ItemDBO> input) {
            return ListUtils.toMapper(input);
          }
        });
    DataSource.Factory<Integer, ItemBO> datasource =
        ItemsDatabase.getDatabase(application).itemsDAO().getAllPaged().map(new Function<ItemDBO, ItemBO>() {
          @Override
          public ItemBO apply(ItemDBO input) {
            return input.mapperTo();
          }
        });
    PagedList.Config myPagingConfig = new PagedList.Config.Builder()
        .setPageSize(10)
        .setPrefetchDistance(15)
        .setEnablePlaceholders(true)
        .build();
    LivePagedListBuilder<Integer, ItemBO> builder = new LivePagedListBuilder<>(datasource, myPagingConfig);
    itemPagedList = builder.build();
  }

  public LiveData<List<ItemBO>> getItemList() {
    return itemList;
  }

  public LiveData<PagedList<ItemBO>> getItemListPaged(){
    return itemPagedList;
  }

  public void requestData() {
    JobInfo jobInfo = ApiJob.getApiJobInfo(getApplication(), DownloadItemsJob.class, null);
    JobExecutor.scheduleJob(getApplication(), jobInfo);
  }
}
