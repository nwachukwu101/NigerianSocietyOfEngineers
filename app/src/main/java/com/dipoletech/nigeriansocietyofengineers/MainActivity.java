package com.dipoletech.nigeriansocietyofengineers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.inthecheesefactory.thecheeselibrary.fragment.support.v4.app.bus.ActivityResultBus;
import com.inthecheesefactory.thecheeselibrary.fragment.support.v4.app.bus.ActivityResultEvent;

public class MainActivity extends AppCompatActivity implements
        AboutUsFragment.OnFragmentInteractionListener,
        ContactUsFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        PaymentsFragment.OnFragmentInteractionListener,
        InfoFragment.OnFragmentInteractionListener{

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

        //swap the fragment home
        swapFragment(new MainActivityFragment(),"my NSE");

        //set the navigation ite, click listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.action_home:
                        swapFragment(new MainActivityFragment(),"my NSE");
                        drawerlayout.closeDrawers();
                        break;
                    case R.id.action_about_us:
                        swapFragment(new AboutUsFragment(),"About NSE");
                        drawerlayout.closeDrawers();
                        break;
                    case R.id.action_contact_us:
                        swapFragment(new ContactUsFragment(),"Contact NSE");
                        drawerlayout.closeDrawers();
                        break;

                }

                return true;
            }
        });



    }

    private void swapFragment(Fragment fragment, String title) {
        getSupportActionBar().setTitle(title);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        //fragmentTransaction.addToBackStack(title);
        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(
                new ActivityResultEvent(requestCode,resultCode,data));
    }
}
