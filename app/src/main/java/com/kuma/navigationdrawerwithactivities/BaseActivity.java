package com.kuma.navigationdrawerwithactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Kuma on 5/1/17.
 */
public class BaseActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  protected DrawerLayout drawer;
  protected NavigationView navigationView;
  protected ConstraintLayout constraintLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null)
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    navigationView = (NavigationView) findViewById(R.id.nav_view);
    constraintLayout = (ConstraintLayout) findViewById(R.id.content_main);

    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override protected void onResume() {
    super.onResume();
    int size = navigationView.getMenu().size();
    for (int i = 0; i < size; i++) {
      navigationView.getMenu().getItem(i).setChecked(false);
    }
  }

  @Override public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START))
      drawer.closeDrawer(GravityCompat.START);
    else if (getSupportActionBar().getTitle().equals(getString(R.string.app_name)))
      finish();
    else
      launchActivity(new Intent(this, BaseActivity.class));
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    if (item.isChecked()) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      int id = item.getItemId();
      Intent intent = null;

      switch (id) {
        case R.id.nav_camera:
          intent = new Intent(BaseActivity.this, ImportActivity.class);
          break;
        case R.id.nav_gallery:
          intent = new Intent(BaseActivity.this, GalleryActivity.class);
          break;
        case R.id.nav_slideshow:
          intent = new Intent(BaseActivity.this, SlideshowActivity.class);
          break;
        case R.id.nav_manage:
          intent = new Intent(BaseActivity.this, ToolsActivity.class);
          break;
        case R.id.nav_share:
          Toast.makeText(this, getString(R.string.share_toast), Toast.LENGTH_SHORT).show();
          break;
        case R.id.nav_send:
          Toast.makeText(this, getString(R.string.send_toast), Toast.LENGTH_SHORT).show();
          break;
        default:
          intent = new Intent(BaseActivity.this, BaseActivity.class);
          break;
      }

      drawer.closeDrawer(GravityCompat.START);
      launchActivity(intent);
    }

    return true;
  }

  private void launchActivity(Intent intent) {
    if (intent != null) {
      startActivity(intent);
      finish();
      overridePendingTransition(0, 0);
    }
  }

}