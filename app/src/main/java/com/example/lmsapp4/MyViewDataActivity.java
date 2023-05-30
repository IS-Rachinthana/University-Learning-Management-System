package com.example.lmsapp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyViewDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ViewAdpterModel viewAdpterModel;

    ArrayList<SenderModel>list;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference studentResultDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_data);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase= FirebaseDatabase.getInstance();
        studentResultDbRef = firebaseDatabase.getReference("StudentsMarks");

        list = new ArrayList<>();
        viewAdpterModel= new ViewAdpterModel(this,list);
        recyclerView.setAdapter(viewAdpterModel);
        studentResultDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot db: snapshot.getChildren()){
                   SenderModel senderModel=db.getValue(SenderModel.class);
                   list.add(senderModel);

                }
               viewAdpterModel.notifyDataSetChanged();
                Toast.makeText(MyViewDataActivity.this,"Successfull", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MyViewDataActivity.this,""+error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}