package com.kuma.navigationdrawerwithactivities;

import android.os.Bundle;

public class ImportActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getLayoutInflater().inflate(R.layout.activity_import, constraintLayout);
    setTitle(getString(R.string.activity_import));
  }

  @Override protected void onResume() {
    super.onResume();
    navigationView.getMenu().getItem(0).setChecked(true);
  }

}