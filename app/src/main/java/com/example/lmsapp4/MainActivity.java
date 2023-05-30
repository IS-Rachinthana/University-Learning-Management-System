package com.example.lmsapp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
     Button  btnInsertData;
     Button  retieveViewDataBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_view_lecture_materials:
                openUploadLectureMaterials();

                break;
            case R.id.nav_lecture_schedule:
                openLectureScheduleActivity();
                break;
            case R.id.nav_result_exam_and_assignment:
                openExamResultInsert();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void openLectureScheduleActivity() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, lecture_shedule_section.class);
        startActivity(intent);
    }

    private void openUploadLectureMaterials() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, lecture_material_view.class);
        startActivity(intent);
    }

    private void openExamResultInsert() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, exam_and_assignment_result_insert.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}