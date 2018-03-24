package com.example.maham.classassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private EditText name,email,num;
    private String names,emails,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       name=(EditText)findViewById(R.id.editText);
       email=(EditText)findViewById(R.id.editText2);
       num=(EditText)findViewById(R.id.editText3);


        Button join =(Button)findViewById(R.id.join);

            join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  login();
                }
            });}


    public void login(){
        initialize();
        if (!validate())
            {
            Toast.makeText(this, "Fill Fields Properly", Toast.LENGTH_SHORT).show();
            }
        else
            {
            successfull();
            }
    }

    public boolean validate(){
        boolean valid =true;
        if(names.isEmpty()||names.length()>10){
            name.setError("Enter Valid Name");
            valid=false;
        }
        if(emails.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(emails).matches()){
            email.setError("Enter Valid Email");
            valid=false;
        }
        if(number.isEmpty()|| number.length()<11){
            num.setError("Enter Valid Number");
            valid=false;
        }
        return valid;
    }

    public void successfull() {
        Intent i =new Intent(signup.this,menus.class);
        startActivity(i);
    }

    public void initialize() {
        names=name.getText().toString().trim();
        emails=email.getText().toString().trim();
        number=num.getText().toString().trim();
    }


}



