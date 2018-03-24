package com.example.maham.classassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name=(TextView)findViewById(R.id.name);
        TextView des = (TextView)findViewById(R.id.description);
        TextView price = (TextView)findViewById(R.id.price);
       ImageView image= (ImageView)findViewById(R.id.imageid);


        Intent i =getIntent();
        name.setText(i.getStringExtra("NAME"));
        des.setText(i.getStringExtra("DETAILS"));
        price.setText(i.getStringExtra("PRICE"));
        image.setImageResource(i.getIntExtra("ID",R.drawable.mens));

        Button order=(Button)findViewById(R.id.orderit);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Details.this,Order.class);
                startActivity(i);
            }
        });
    }
}
