package com.josefuentes.prettydeprecated.task;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class JobExecutor {
  public static void scheduleJob(Context context, Class clazz) {
    scheduleJob(context, getJobInfo(context, clazz).build());
  }

  public static void scheduleJob(Context context, JobInfo jobInfo) {
    JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    jobScheduler.schedule(jobInfo);
  }

  public static JobInfo.Builder getJobInfo(Context context, Class clazz) {
    ComponentName componentName = new ComponentName(context, clazz);
    return new JobInfo.Builder(clazz.hashCode(), componentName);
  }
}
