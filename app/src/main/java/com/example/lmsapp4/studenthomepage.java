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
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class studenthomepage extends AppCompatActivity {
    private DrawerLayout drawer_layout_student;
    Button btnInsertData;
    Button  retieveViewDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenthomepage);


        Toolbar toolbar = findViewById(R.id.toolbar_student); //Ignore red line errors
        setSupportActionBar(toolbar);
         drawer_layout_student = findViewById(R.id.drawer_layout_student);
        NavigationView navigationView = findViewById(R.id.nav_view_student);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout_student,toolbar, R.string.open_nav,
                R.string.close_nav);
        drawer_layout_student.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_student, new StudentHomeDashboard()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_student, new StudentHomeDashboard()).commit();
                break;
            case R.id.nav_view_lecture_materials:
                openUploadLectureMaterialsStudent();

                break;
            case R.id.nav_lecture_schedule:
                openLectureScheduleActivity();
                break;
            case R.id.nav_result_exam_and_assignment:
                openStudentResultDispaly();
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
        drawer_layout_student.closeDrawer(GravityCompat.START);
        return true;
    }
    private void openLectureScheduleActivity() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, student_lecture_time_table_view.class);
        startActivity(intent);
    }

    private void openUploadLectureMaterialsStudent() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, student_lecture_material_view.class);
        startActivity(intent);
    }

    private void openExamResultInsert() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, exam_and_assignment_result_insert.class);
        startActivity(intent);
    }

    private void openStudentResultDispaly() {
        // Perform the action for "nav_lecture_schedule" case

        Intent intent = new Intent(this, MyViewDataActivity.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        if (drawer_layout_student.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_student.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}