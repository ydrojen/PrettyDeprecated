package com.josefuentes.prettydeprecated.ui.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.josefuentes.prettydeprecated.R;

public class SettingsActivity extends PreferenceActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preferences);
  }

}