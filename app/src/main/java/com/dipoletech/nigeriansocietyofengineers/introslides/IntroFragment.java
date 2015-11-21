package com.dipoletech.nigeriansocietyofengineers.introslides;/**
 * Created by DABBY(3pleMinds) on 20-Nov-15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dipoletech.nigeriansocietyofengineers.R;

/**
 * DABBY(3pleMinds) 20-Nov-15 12:37 PM 2015 11
 * 20 12 37 NigerianSocietyOfEngineers
 **/
public class IntroFragment extends Fragment {
    private View rootView;

    public IntroFragment()
    {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.intro,container,false);
        return rootView;
    }
}
