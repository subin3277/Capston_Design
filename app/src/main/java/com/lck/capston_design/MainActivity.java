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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Context context =this;

    LinearLayout diet,yoga,hosp,cal;
    TextView tv_navi_name,setting;
    static TextView expect, tv_dday;
    String name;
    static String user_idx,user_id,user_age,user_expecteddate;
    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diet=findViewById(R.id.main_menu_diet);
        yoga=findViewById(R.id.main_menu_yoga);
        hosp=findViewById(R.id.main_menu_hos);
        expect = findViewById(R.id.main_expectdate);
        tv_dday=findViewById(R.id.main_dday);
        cal=findViewById(R.id.main_menu_calendar);
        setting = findViewById(R.id.main_menu_setting);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("user_name");
        user_id = bundle.getString("user_id");
        user_idx = bundle.getString("user_idx");
        user_expecteddate = bundle.getString("expectedDate");
        user_age = bundle.getString("user_age");

        String[] date1 = user_expecteddate.split("T");
        expect.setText(date1[0]);

        String[] expectedDatelist = date1[0].split("-");
        getDday(Integer.parseInt(expectedDatelist[0]),Integer.parseInt(expectedDatelist[1])-1,Integer.parseInt(expectedDatelist[2]));


        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id = item.getItemId();
                String title = item.getTitle().toString();

                if (id==R.id.tab_eat){
                    Intent intent = new Intent(MainActivity.this, DietActivity.class);
                    startActivity(intent);
                    finish();

                }
                else if (id==R.id.tab_yoga){
                    Intent intent = new Intent(MainActivity.this, YogaActivity.class);
                    startActivity(intent);
                    finish();

                }
                else if (id==R.id.tab_hos){
                    Intent intent = new Intent(MainActivity.this, HospitalActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (id == R.id.tab_logout){
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = auto.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                }
                else if (id == R.id.tab_set){
                    Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (id==R.id.tab_findhos){
                    Intent intent = new Intent(MainActivity.this,FindhospitalActivity.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            }
        });


        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DietActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);

            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, YogaActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);

            }
        });
        hosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindhospitalActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);

            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HospitalActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);

            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0 <= gapTime && 2000 >= gapTime) {
            super.onBackPressed();
        }
        else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    static public void getDday(int year, int month, int day){
        try {
            Calendar today = Calendar.getInstance();
            Calendar dday = Calendar.getInstance();

            dday.set(year,month,day);

            long l_dday = dday.getTimeInMillis()/(24*60*60*1000);
            long l_today = today.getTimeInMillis()/(24*60*60*1000);

            long substract = l_dday-l_today;

            Log.e("substract", String.valueOf(substract));
            tv_dday.setText(substract+"일 남았습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}