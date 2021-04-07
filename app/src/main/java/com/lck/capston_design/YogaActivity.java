package com.lck.capston_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class YogaActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Context context = this;
    static String yoga_idx;

    TextView firstbtn,secondbtn,thirdbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        firstbtn=findViewById(R.id.yoga_btn_1st);
        secondbtn = findViewById(R.id.yoga_btn_2nd);
        thirdbtn=findViewById(R.id.yoga_btn_3rd);

        Toolbar toolbar = (Toolbar) findViewById(R.id.yoga_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        drawerLayout = (DrawerLayout) findViewById(R.id.yoga_drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.yoga_nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id = item.getItemId();
                String title = item.getTitle().toString();

                if (id == R.id.tab_eat) {
                    Intent intent = new Intent(YogaActivity.this, DietActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.tab_yoga) {
                    Intent intent = new Intent(YogaActivity.this, YogaActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.tab_hos) {
                    Intent intent = new Intent(YogaActivity.this, HospitalActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (id == R.id.tab_logout){
                    Intent intent = new Intent(YogaActivity.this,LoginActivity.class);
                    startActivity(intent);
                    SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = auto.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                }
                else if (id == R.id.tab_set){
                    Intent intent = new Intent(YogaActivity.this,SettingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (id==R.id.tab_findhos){
                    Intent intent = new Intent(YogaActivity.this,FindhospitalActivity.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            }
        });

        firstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaActivity.this,Yoga1stActivity.class);
                yoga_idx = "1st";
                startActivity(intent);
            }
        });

        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaActivity.this,Yoga1stActivity.class);
                yoga_idx = "2nd";
                startActivity(intent);
            }
        });

        thirdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaActivity.this,Yoga1stActivity.class);
                yoga_idx = "3rd";
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}