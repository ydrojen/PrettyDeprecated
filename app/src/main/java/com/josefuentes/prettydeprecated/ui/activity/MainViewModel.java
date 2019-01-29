package com.josefuentes.prettydeprecated.ui.activity;

import android.app.Application;
import android.app.job.JobInfo;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
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

  public MainViewModel(@NonNull Application application) {
    super(application);
    itemList = Transformations.map(ItemsDatabase.getDatabase(application).itemsDAO().getAll(),
        new Function<List<ItemDBO>, List<ItemBO>>() {
          @Override
          public List<ItemBO> apply(List<ItemDBO> input) {
            return ListUtils.toMapper(input);
          }
        });
  }

  public LiveData<List<ItemBO>> getItemList() {
    return itemList;
  }

  public void requestData() {
    JobInfo jobInfo = ApiJob.getApiJobInfo(getApplication(), DownloadItemsJob.class, null);
    JobExecutor.scheduleJob(getApplication(), jobInfo);
  }
}
