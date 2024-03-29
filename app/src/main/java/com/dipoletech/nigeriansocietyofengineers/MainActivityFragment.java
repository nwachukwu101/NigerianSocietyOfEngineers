package com.dipoletech.nigeriansocietyofengineers;

import android.graphics.Color;
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
    private ViewPagerAdapter adapter;

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

        tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getIcon().setTint(
                getActivity().getResources().getColor(R.color.tint_bg)
        );

        //set the tab texts to be small
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
                tab.getIcon().setTint(getActivity().getResources().getColor(R.color.tint_bg));
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
                tab.getIcon().setTint(Color.GRAY);


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }



    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ProfileFragment(), "my Profile");
        adapter.addFragment(new PaymentsFragment(), "Payments");
        adapter.addFragment(new InfoFragment(), "Notices");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.ic_action_user,
                R.drawable.ic_action_paypal,
                R.drawable.ic_action_planet
        };


        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(0).getIcon().setTint(Color.GRAY);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(1).getIcon().setTint(Color.GRAY);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(2).getIcon().setTint(Color.GRAY);
    }



}
