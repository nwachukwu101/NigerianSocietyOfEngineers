package com.dipoletech.nigeriansocietyofengineers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Authentication extends AppCompatActivity implements
        AuthenticationFragment.toLoginOrRegister,
        LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener,
        LoginFragment.loginButtonClicked{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        swapFragment(new AuthenticationFragment(),"Authentication");

    }

    @Override
    public void toLoginButtonClicked() {
        //swap the login fragment using fragment transaction
        swapFragment(new LoginFragment(),"Login");
    }

    private void swapFragment(Fragment fragment, String title) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.fragment,fragment);
        fragTrans.addToBackStack(fragment.getClass().getSimpleName());
        fragTrans.commit();
    }

    @Override
    public void toRegisterButtonClicked() {
        //swap the register fragment using the fragment transactions
        swapFragment(new RegisterFragment(),"Register");

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount()==0)
        {
            finish();
        }else {
            getSupportActionBar().setTitle("Authentication");
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void loginButtonClicked() {
        //start the main activity once the user has been loged in
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
