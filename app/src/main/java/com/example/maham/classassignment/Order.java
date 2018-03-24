package com.example.maham.classassignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Order extends AppCompatActivity {

    private EditText name,email,num,address;
    private String names,emails,number,addresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name=(EditText)findViewById(R.id.editText);
        email=(EditText)findViewById(R.id.editText2);
        num=(EditText)findViewById(R.id.editText3);
        address=(EditText)findViewById(R.id.editText1);


        Button confirm =(Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
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
        if(addresses.isEmpty()){
            address.setError("Enter Valid Address");
            valid=false;
        }
        return valid;
    }

    public void successfull() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Order.this);
        builder1.setMessage("You have placed an order.");
        builder1.setCancelable(true);
        builder1.setNegativeButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent i =new Intent(Order.this,menus.class);
                        startActivity(i);
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void initialize() {
        names=name.getText().toString().trim();
        emails=email.getText().toString().trim();
        number=num.getText().toString().trim();
        addresses=address.getText().toString().trim();
}
}
