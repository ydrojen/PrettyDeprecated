package com.josefuentes.prettydeprecated.task.jobs;

import android.app.job.JobParameters;
import com.josefuentes.prettydeprecated.data.bd.ItemsDatabase;
import com.josefuentes.prettydeprecated.data.cloud.ApiManager;
import com.josefuentes.prettydeprecated.data.cloud.ItemDTO;
import com.josefuentes.prettydeprecated.data.cloud.ItemsService;
import com.josefuentes.prettydeprecated.task.ApiJob;
import com.josefuentes.prettydeprecated.util.ListUtils;
import java.util.List;
import retrofit2.Call;

public class DownloadItemsJob extends ApiJob<List<ItemDTO>> {
  @Override
  protected void processData(JobParameters params, List<ItemDTO> data) {
    ItemsDatabase.getDatabase(getApplicationContext()).itemsDAO().insert(ListUtils.toMapper(data));
  }

  @Override
  protected Call<List<ItemDTO>> createCall(JobParameters params) {
    return ApiManager.getService(ItemsService.class).getItems();
  }
}
