package com.kuma.navigationdrawerwithactivities;

import android.os.Bundle;

public class ToolsActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getLayoutInflater().inflate(R.layout.activity_tools, constraintLayout);
    setTitle(getString(R.string.activity_tools));
  }

  @Override protected void onResume() {
    super.onResume();
    navigationView.getMenu().getItem(3).setChecked(true);
  }

}