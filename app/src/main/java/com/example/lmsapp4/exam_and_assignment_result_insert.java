package com.example.lmsapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class exam_and_assignment_result_insert extends AppCompatActivity {
    Button retieveViewDataBtn;
    EditText studentName;
    EditText studentIndexNum;
    Spinner selectTypeActivity;
    Spinner selectTypeDegree;
    EditText batchName;
    EditText moduleName;
    EditText studentMarks;
    Button btnInsertData;

    DatabaseReference studentResultDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_and_assignment_result_insert);

        retieveViewDataBtn=  findViewById(R.id.retieveViewDataBtn);

        studentName = findViewById(R.id.studentName);
        studentIndexNum = findViewById(R.id.studentIndexNum);
        selectTypeActivity = findViewById(R.id.selectTypeActivity);
        selectTypeDegree = findViewById(R.id.selectTypeDegree);
        batchName = findViewById(R.id.batchName);
        moduleName = findViewById(R.id.moduleName);
        studentMarks = findViewById(R.id.studentMarks);
        btnInsertData = findViewById(R.id.btnInsertData);

        studentResultDbRef = FirebaseDatabase.getInstance().getReference().child("StudentsMarks");

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStudentResultData();
            }
        });
        retieveViewDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyViewDataActivity.class);
                startActivity(intent);
            }
        });

    }

    private void insertStudentResultData(){
        String name= studentName.getText().toString();
        String indexNo = studentIndexNum.getText().toString();
        String activityType= selectTypeActivity.getSelectedItem().toString();
        String degreeType= selectTypeDegree.getSelectedItem().toString();
        String batchesName = batchName.getText().toString();
        String moduleNam = moduleName.getText().toString();
        String stuMarks=studentMarks.getText().toString();

        SenderModel students = new SenderModel(name,indexNo,activityType,degreeType,batchesName,moduleNam,stuMarks);

        studentResultDbRef.push().setValue(students);
        Toast.makeText(exam_and_assignment_result_insert.this, "Data Inserted!", Toast.LENGTH_SHORT).show();



    }
}