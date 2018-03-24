package com.example.maham.classassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MensWears extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_wears);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView men1=(ImageView) findViewById(R.id.men1);
        ImageView men2=(ImageView) findViewById(R.id.man2);
        final TextView name1 =(TextView)findViewById(R.id.textView3);
        final TextView name2 =(TextView)findViewById(R.id.textView4);
        final TextView price1 =(TextView)findViewById(R.id.textView5);
        final TextView price2 =(TextView)findViewById(R.id.textView6);
        men1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageid= R.drawable.tshirtmen;
                String name = name1.getText().toString();
                String price = price1.getText().toString();
                String details= " Sizes available in 5 different colors";
                Intent i =new Intent(MensWears.this,Details.class);
                i.putExtra("ID",imageid);
                i.putExtra("NAME",name);
                i.putExtra("PRICE",price);
                i.putExtra("DETAILS",details);
                startActivity(i);

            }
        });

        men2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imageid=R.drawable.shirtmen;
                String name = name2.getText().toString();
                String price = price2.getText().toString();
                String details= " Sizes available in 2 different colors";
                Intent i =new Intent(MensWears.this,Details.class);
                i.putExtra("ID",imageid);
                i.putExtra("NAME",name);
                i.putExtra("PRICE",price);
                i.putExtra("DETAILS",details);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i =new Intent (MensWears.this,menus.class);
            startActivity(i);
        }
        else if (id == R.id.nav_men) {
            Intent i =new Intent (MensWears.this,MensWears.class);
            startActivity(i);
        } else if (id == R.id.nav_women) {
            Intent i =new Intent (MensWears.this,WomensWears.class);
            startActivity(i);
        } else if (id == R.id.nav_kids) {
            Intent i =new Intent (MensWears.this,KidsWears.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
