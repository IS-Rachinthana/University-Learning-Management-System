package com.example.lmsapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

EditText _login_email,_login_password;
Button _login_button;
Spinner _spinner_login_usertype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        _login_email=(EditText)findViewById(R.id.login_email);
        _login_password=(EditText)findViewById(R.id.login_password);
        _login_button=(Button)findViewById(R.id.login_button);
        _spinner_login_usertype=(Spinner)findViewById(R.id.spinner_login_usertype);

        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource( this, R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        _spinner_login_usertype.setAdapter(adapter);
        _login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = _spinner_login_usertype.getSelectedItem().toString();
                if(_login_email.getText().toString().equals("admin@gmail.com") && _login_password.getText().toString().equals("admin") && item.equals("Admin")) {
                    Intent intent = new Intent(SignInActivity.this, adminhomepage.class);
                    startActivity(intent);
                } else if(_login_email.getText().toString().equals("student@gmail.com") && _login_password.getText().toString().equals("student") && item.equals("Student")) {
                    Intent intent = new Intent(SignInActivity.this, studenthomepage.class);
                    startActivity(intent);
                } else if(_login_email.getText().toString().equals("lecturer@gmail.com") && _login_password.getText().toString().equals("lecturer") && item.equals("Lecturer")) {
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}