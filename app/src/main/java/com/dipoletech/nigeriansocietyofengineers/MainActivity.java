package com.dipoletech.nigeriansocietyofengineers;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerlayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize the drawer layout
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        //action bar drawer Toggle
        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerlayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };

        //set the drawerLayout Listener
        drawerlayout.setDrawerListener(drawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        drawerToggle.syncState();


        //initialise the Navigation view
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //make all the menu icons to appear as required
        navigationView.setItemIconTintList(null);


    }

}
