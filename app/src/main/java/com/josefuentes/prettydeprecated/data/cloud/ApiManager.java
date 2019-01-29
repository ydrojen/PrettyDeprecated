package com.josefuentes.prettydeprecated.data.cloud;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

  private static final String BASE_URL = "https://data.ct.gov/";

  private static OkHttpClient getOkHttpClient() {
    HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
    logger.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder()
        .addInterceptor(logger)
        .build();
  }

  private static Retrofit getRetrofit() {
    return new Retrofit.Builder()
        .client(getOkHttpClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static <T> T getService(final Class<T> service) {
    return getRetrofit().create(service);
  }
}
