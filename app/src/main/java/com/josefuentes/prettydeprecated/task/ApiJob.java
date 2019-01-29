package com.josefuentes.prettydeprecated.task;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Response;

public abstract class ApiJob<E> extends JobService {

  public static JobInfo getApiJobInfo(Context context, Class clazz, PersistableBundle params) {
    JobInfo.Builder jobInfo = JobExecutor.getJobInfo(context, clazz)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
    if (params != null) {
      jobInfo.setExtras(params);
    }
    return jobInfo.build();
  }

  @Override
  public boolean onStartJob(JobParameters params) {
    startWorkOnNewThread(params);
    return true;
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    return false;
  }

  private void startWorkOnNewThread(final JobParameters params) {
    new Thread(new Runnable() {
      public void run() {
        doWork(params);
      }
    }).start();
  }

  private void doWork(JobParameters params) {
    boolean retry = false;
    try {
      Call<E> call = createCall(params);
      Response<E> response = call.execute();
      if (response.isSuccessful()) {
        processData(params, response.body());
      } else {
        retry = retryOnError(params);
      }
    } catch (Exception e) {
      Log.i("ApiJob", "Execution error", e);
    }

    jobFinished(params, retry);
  }

  protected boolean retryOnError(JobParameters params) {
    return false;
  }

  protected abstract void processData(JobParameters params, E data);

  protected abstract Call<E> createCall(JobParameters params);
}
