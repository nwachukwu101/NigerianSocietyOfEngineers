package com.dipoletech.nigeriansocietyofengineers;

import android.content.Intent;
import android.os.Bundle;

import com.dipoletech.nigeriansocietyofengineers.introslides.IntroFragment;
import com.github.paolorotolo.appintro.AppIntro;

public class Intro extends AppIntro {


    @Override
    public void init(Bundle savedInstanceState) {

        addSlide(new IntroFragment());
    }

    @Override
    public void onSkipPressed() {
        startActivity(new Intent(this,Authentication.class));
        finish();

    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this, Authentication.class));
        finish();

    }
}
