package com.kuma.navigationdrawerwithactivities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;

public class SlideshowActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getLayoutInflater().inflate(R.layout.activity_slideshow, constraintLayout);
    setTitle(getString(R.string.activity_slideshow));
  }

  @Override protected void onResume() {
    super.onResume();
    navigationView.getMenu().getItem(2).setChecked(true);
  }

}