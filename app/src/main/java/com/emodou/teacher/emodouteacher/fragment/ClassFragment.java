package com.emodou.teacher.emodouteacher.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emodou.teacher.emodouteacher.R;
import com.emodou.teacher.emodouteacher.adapter.ClassFragmentAdapter;
import com.emodou.teacher.emodouteacher.fragment.base.BaseFragment;
import com.hannesdorfmann.fragmentargs.annotation.Arg;

import java.util.ArrayList;

/**
 * @author yy
 * @since  2015 6 2
 */
public class ClassFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    @Arg
    private String title;
    //主窗口
    private ViewPager mPager;
    //存储fragment的集合
    private ArrayList<Fragment> fragmentsList;
    //三个标签
    private TextView tvAssignment, tvSolvePuzzle, tvNotice;



    public ClassFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mPager = (ViewPager) view.findViewById(R.id.vp_class);

        fragmentsList = new ArrayList<Fragment>();
        fragmentsList.add(AssignmentFragment.newInstance("hhh", "dfsdf"));
        fragmentsList.add(SolvePuzzleFragment.newInstance("dfsfs", "jljkl"));
        fragmentsList.add(NoticeFragment.newInstance("s", "b"));

        mPager.setAdapter(new ClassFragmentAdapter(getChildFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

        mPager.bringToFront();

        tvAssignment = (TextView) view.findViewById(R.id.tv_assignment);
        tvSolvePuzzle = (TextView) view.findViewById(R.id.tv_solve_puzzle);
        tvNotice = (TextView) view.findViewById(R.id.tv_notice);

    }



    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            System.out.println("Position" + position + positionOffset + positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    tvAssignment.setTextColor(Color.rgb(153, 151, 152));
                    tvSolvePuzzle.setTextColor(Color.rgb(221, 221, 221));
                    tvNotice.setTextColor(Color.rgb(221, 221, 221));
                    break;
                case 1:
                    tvAssignment.setTextColor(Color.rgb(221, 221, 221));
                    tvSolvePuzzle.setTextColor(Color.rgb(153, 151, 152));
                    tvNotice.setTextColor(Color.rgb(221, 221, 221));
                    break;
                case 2:
                    tvAssignment.setTextColor(Color.rgb(221, 221, 221));
                    tvSolvePuzzle.setTextColor(Color.rgb(221, 221, 221));
                    tvNotice.setTextColor(Color.rgb(153, 151, 152));
                    break;


            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
    System.out.println(state);
        }
    }

}
