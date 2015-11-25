package com.dipoletech.nigeriansocietyofengineers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dipoletech.nigeriansocietyofengineers.app.AppController;
import com.dipoletech.nigeriansocietyofengineers.utils.AppConfig;
import com.dipoletech.nigeriansocietyofengineers.utils.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Authentication extends AppCompatActivity implements
        AuthenticationFragment.toLoginOrRegister,
        LoginFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener,
        LoginFragment.loginButtonClicked,
        RegisterFragment.registerUser{

    private Toolbar toolbar;
    private SessionManager session;
    private ProgressDialog pDialog;
    private String TAG = Authentication.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //check is the user is logged in

        // session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            swapFragment(new AuthenticationFragment(), "Authentication");

            // Progress dialog
            pDialog = new ProgressDialog(this);
            pDialog.setCancelable(false);
        }

    }

    private void logoutUser() {

    }

    @Override
    public void toLoginButtonClicked() {
        //swap the login fragment using fragment transaction
        swapFragment(new LoginFragment(), "Login");
    }


    @Override
    public void toRegisterButtonClicked() {
        //swap the register fragment using the fragment transactions
        swapFragment(new RegisterFragment(), "Register");

    }


    //this method swaps fragments in the authenticate Activity
    private void swapFragment(Fragment fragment, String title) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.fragment, fragment);
        fragTrans.addToBackStack(fragment.getClass().getSimpleName());
        fragTrans.commit();
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
    public void loginButtonClicked(String email, String password) {
        //start the main activity once the user has been loged in
        checkLogin(email, password);
        if (session.isLoggedIn())
        {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }


    }

    private void checkLogin(final String email, final String password) {

        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                AppConfig.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d(TAG, "Login Response: " + response.toString());
                        hideDialog();

//                        try {
//                            JSONObject jObj = new JSONObject(response);
//                            boolean error = jObj.getBoolean("error");
//
//                            // Check for error node in json
//                            if (!error) {
//                                // user successfully logged in
//                                // Create login session
//                                session.setLogin(true);
//                            } else {
//                                // Error in login. Get the error message
//                                String errorMsg = jObj.getString("errorMessage");
//                                Toast.makeText(getApplicationContext(),
//                                        errorMsg, Toast.LENGTH_LONG).show();
//                                session.setLogin(false);
//                            }
//                        } catch (JSONException e) {
//                            // JSON error
//                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                        }

                    }


                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();

            }
        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                //put some params here
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("email", email);
//                params.put("password",password);
//
//                return params;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String,String> headers =  new HashMap<String,String>();
//                headers.put("Content-Type","application/x-www-form-urlencoded");
//                return headers;
//
//            }
        };


        //return true or false here
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);

    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void registerButtonClicked(final String name, final String email, final String password) {
        //try creating a new user, if successful,take the person to Login
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Loading ...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d(TAG, "Registration Response: " + response.toString());
                        hideDialog();

                        try {
                            JSONObject jObj = new JSONObject(response);
                            boolean error = jObj.getBoolean("error");

                            // Check for error node in json
                            if (!error) {
                                // user successfully created

                            } else {
                                // Error in login. Get the error message
                                String errorMsg = jObj.getString("errorMessage");
                                Toast.makeText(getApplicationContext(),
                                        errorMsg, Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            // JSON error
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e(TAG, "Registration Error: " + error.getMessage());
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_LONG).show();
                        hideDialog();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //put some params here
                Map<String, String> params = new HashMap<String, String>();
                params.put("name",name);
                params.put("email", email);
                params.put("password", password);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> headers = new HashMap<String,String>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                return headers;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }
}
