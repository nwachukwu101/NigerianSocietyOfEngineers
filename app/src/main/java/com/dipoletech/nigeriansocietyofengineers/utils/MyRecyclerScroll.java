package com.dipoletech.nigeriansocietyofengineers.utils;/**
 * Created by DABBY(3pleMinds) on 23-Nov-15.
 */

import android.support.v7.widget.RecyclerView;

/**
 * DABBY(3pleMinds) 23-Nov-15 1:15 AM 2015 11
 * 23 01 15 NigerianSocietyOfEngineers
 **/
public abstract class MyRecyclerScroll extends RecyclerView.OnScrollListener {

    int scrollDist = 0;
    boolean isVisible = true;
    static final float MINIMUM = 25;
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isVisible && scrollDist>MINIMUM)
        {
            hide();
            scrollDist = 0;
            isVisible =false;
        }
        else if (!isVisible && scrollDist<-MINIMUM){

            show();
            scrollDist = 0;
            isVisible =true;
        }

        if ((isVisible && dy>0)||(!isVisible && dy<0))
            scrollDist+=dy;
    }

    protected abstract void show();

    protected abstract void hide();
}
