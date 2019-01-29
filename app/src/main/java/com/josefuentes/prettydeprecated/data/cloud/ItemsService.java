package com.josefuentes.prettydeprecated.data.cloud;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemsService {
  @GET("resource/hma6-9xbg.json")
  Call<List<ItemDTO>> getItems();
}
