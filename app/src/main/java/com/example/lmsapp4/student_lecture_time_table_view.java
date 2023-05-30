package com.example.lmsapp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class student_lecture_time_table_view extends AppCompatActivity {
    private CalendarView student_calendarView;
    private EditText lecturesinfo;

    //private EditText editText2;
    private String stringDateSelected;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_lecture_time_table_view);

        student_calendarView = findViewById(R.id.student_calendarView);
        lecturesinfo = findViewById(R.id.lecturesinfo);
        //  editText = findViewById(R.id.editText2);

        student_calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                stringDateSelected = Integer.toString(year) + Integer.toString(month+1) + Integer.toString(dayOfMonth);
                calendarClicked();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");
    }



    private void calendarClicked()
    {
        databaseReference.child(stringDateSelected).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue()!=null)
                {
                    lecturesinfo.setText(snapshot.getValue().toString());


                } //else if (snapshot.getValue()!=null) {
                //editText2.setText(snapshot.getValue().toString());
                // }
                else
                {
                    lecturesinfo.setText("null");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void buttonSaveEvent(View view){
        databaseReference.child(stringDateSelected).setValue(lecturesinfo.getText().toString());
        // databaseReference.child(stringDateSelected).setValue(editText2.getText().toString());

    }
}