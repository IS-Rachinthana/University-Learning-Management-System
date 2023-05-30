package com.example.lmsapp4;

import static com.example.lmsapp4.R.id.calendarView;
import static com.example.lmsapp4.R.id.imageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class lecture_shedule_section extends AppCompatActivity {
    private CalendarView calendarView;
    private EditText editText;

    //private EditText editText2;
    private String stringDateSelected;
    private DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnActivityMain;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture_shecdule_calenderview);




        calendarView = findViewById(R.id.calendarView);
        editText = findViewById(R.id.editText);
      //  editText = findViewById(R.id.editText2);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
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
                    editText.setText(snapshot.getValue().toString());


                } //else if (snapshot.getValue()!=null) {
                    //editText2.setText(snapshot.getValue().toString());
               // }
               else
                {
                    editText.setText("null");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void buttonSaveEvent(View view){
     databaseReference.child(stringDateSelected).setValue(editText.getText().toString());
    // databaseReference.child(stringDateSelected).setValue(editText2.getText().toString());

    }

}