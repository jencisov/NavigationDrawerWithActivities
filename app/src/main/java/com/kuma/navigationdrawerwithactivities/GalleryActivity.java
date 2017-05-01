package com.kuma.navigationdrawerwithactivities;

import android.os.Bundle;

public class GalleryActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getLayoutInflater().inflate(R.layout.activity_gallery, constraintLayout);
    setTitle(getString(R.string.activity_gallery));
  }

  @Override protected void onResume() {
    super.onResume();
    navigationView.getMenu().getItem(1).setChecked(true);
  }

}