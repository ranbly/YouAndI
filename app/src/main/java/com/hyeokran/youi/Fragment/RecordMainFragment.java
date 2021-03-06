package com.hyeokran.youi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyeokran.youi.Activity.WriteRecordActivity;
import com.hyeokran.youi.Adapter.RecordPagerAdapter;
import com.hyeokran.youi.R;

/**
 * 기록 화면 메인 Fragment
 * Created by GwonHyeok on 2015. 11. 26..
 */
public class RecordMainFragment extends Fragment {
    private static RecordMainFragment instance = null;
    private FloatingActionButton content_record_fab;

    public synchronized static RecordMainFragment getInstance() {
        if (instance == null) {
            instance = new RecordMainFragment();
        }

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_record, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        /* ViewPager Setup */
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.content_record_viewpager);
        RecordPagerAdapter recordPagerAdapter = new RecordPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(recordPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        content_record_fab.show();
                        break;

                    case 1:
                        content_record_fab.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /* TabLayout Setup */
        TabLayout mTabLayout = (TabLayout) view.findViewById(R.id.content_record_tablayout);
        mTabLayout.setupWithViewPager(viewPager);

        content_record_fab = (FloatingActionButton) view.findViewById(R.id.content_record_fab);
        content_record_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WriteRecordActivity.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}