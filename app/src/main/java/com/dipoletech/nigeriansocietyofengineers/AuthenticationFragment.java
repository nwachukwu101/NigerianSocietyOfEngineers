package com.dipoletech.nigeriansocietyofengineers;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class AuthenticationFragment extends Fragment {

    private View rootView;
    private Button toLoginButton, toRegisterButton;

    public interface toLoginOrRegister
    {
        void toLoginButtonClicked();
        void toRegisterButtonClicked();
    }

    public AuthenticationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_authentication, container, false);

        toLoginButton = (Button) rootView.findViewById(R.id.to_login);
        toRegisterButton = (Button) rootView.findViewById(R.id.to_register);

        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((toLoginOrRegister) getActivity()).toLoginButtonClicked();
            }
        });

        toRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((toLoginOrRegister)getActivity()).toRegisterButtonClicked();
            }
        });
        return rootView;
    }


}
