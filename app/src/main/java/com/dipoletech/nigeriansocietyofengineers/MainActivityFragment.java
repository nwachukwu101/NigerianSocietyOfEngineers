package com.dipoletech.nigeriansocietyofengineers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dipoletech.nigeriansocietyofengineers.adapters.ViewPagerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public interface OnFragmentInteractionListener
    {
        public void addSubtitle(String subTitle);
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        //get the viewpager
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //get the tab layout and tweek it
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        //set the tab layout to display middle content
        //tabLayout.getTabAt(1).select();

        //set the tab texts to be small
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index = tab.getPosition();
                switch (index)
                {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ProfileFragment(), "my Profile");
        adapter.addFragment(new ProfileFragment(), "Payments");
        adapter.addFragment(new ProfileFragment(), "Notices");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.ic_action_planet,
                R.drawable.ic_action_planet,
                R.drawable.ic_action_planet
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }



}
