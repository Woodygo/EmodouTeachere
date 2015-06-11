package com.emodou.teacher.emodouteacher.fragment;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.emodou.teacher.emodouteacher.R;
import com.emodou.teacher.emodouteacher.activity.CourseListActivity;
import com.emodou.teacher.emodouteacher.fragment.base.BaseFragment;
import com.emodou.teacher.emodouteacher.util.MyApplication;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar;

public  class HomeFragment extends BaseFragment implements View.OnTouchListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private HoloCircularProgressBar readPb, listenPb, speadPb, wordPb, testPb; //用来显示圆形进度条
    private static String FRAGMENT_TAG = "HomeFragment"; //用来log
    private Context context = HomeFragment.this.getActivity();
    private String bookid,  packageid; //用来在activity之间传递所选课程
    private static String LEARN_TYPE = "learnType";//用来在activity之间传递学习的模块
    private MyApplication app;




    // TODO: Rename and change types of parameters
    @Arg
    private String mParam1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (MyApplication) getActivity().getApplication();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.setFocusable(false);
        initView(view);
        return view;

    }

    /**
     * initial view component
     */
    public void initView(View view) {
        readPb = (HoloCircularProgressBar) view.findViewById(R.id.hcp_read);
        listenPb = (HoloCircularProgressBar) view.findViewById(R.id.hcp_listen);
        speadPb = (HoloCircularProgressBar) view.findViewById(R.id.hcp_speak);
        wordPb = (HoloCircularProgressBar) view.findViewById(R.id.hcp_words);
        testPb = (HoloCircularProgressBar) view.findViewById(R.id.hcp_test);



        readPb.setBackgroundResource(R.drawable.home_read_selector);
        readPb.setThumbEnabled(false);
       // readPb.setActivated(true);
        readPb.setFocusable(true);
        readPb.setWillNotCacheDrawing(true);
        readPb.setHovered(false);
        readPb.setMarkerEnabled(false);
        readPb.setProgressBackgroundColor(Color.rgb(206, 206, 206));
        readPb.setProgressColor( Color.rgb(76, 196, 233));
        readPb.setOnTouchListener(this);

        listenPb.setBackgroundResource(R.drawable.home_listen_selector);
        listenPb.setThumbEnabled(false);
       // listenPb.setActivated(true);
        listenPb.setFocusable(true);
        listenPb.setWillNotCacheDrawing(true);
        listenPb.setHovered(false);
        listenPb.setMarkerEnabled(false);
        listenPb.setProgressBackgroundColor(Color.rgb(206, 206, 206));
        listenPb.setProgressColor( Color.rgb(20, 187, 131));
        listenPb.setOnTouchListener(this);


        speadPb.setBackgroundResource(R.drawable.home_speak_selector);
        speadPb.setThumbEnabled(false);
       // speadPb.setActivated(true);
        speadPb.setFocusable(true);
        speadPb.setWillNotCacheDrawing(true);
        speadPb.setHovered(false);
        speadPb.setMarkerEnabled(false);
        speadPb.setProgressBackgroundColor(Color.rgb(206, 206, 206));
        speadPb.setProgressColor( Color.rgb(20, 187, 131));
        speadPb.setOnTouchListener(this);


        wordPb.setBackgroundResource(R.drawable.home_words_selector);
        wordPb.setThumbEnabled(false);
        //wordPb.setActivated(true);
        wordPb.setFocusable(true);
        wordPb.setWillNotCacheDrawing(true);
        wordPb.setHovered(false);
        wordPb.setMarkerEnabled(false);
        wordPb.setProgressBackgroundColor(Color.rgb(206, 206, 206));
        wordPb.setProgressColor(Color.rgb(211, 92, 192));
        wordPb.setOnTouchListener(this);


        testPb.setBackgroundResource(R.drawable.home_test_selector);
        testPb.setThumbEnabled(false);
        //testPb.setActivated(true);
        testPb.setFocusable(true);
        testPb.setWillNotCacheDrawing(true);
        testPb.setHovered(false);
        testPb.setMarkerEnabled(false);
        testPb.setProgressBackgroundColor(Color.rgb(206, 206, 206));
        testPb.setProgressColor( Color.rgb(20, 187, 131));
        testPb.setOnTouchListener(this);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch (v.getId()){
            case R.id.hcp_read:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    readPb.setBackgroundResource(R.drawable.home_readclick);
                    Log.i(FRAGMENT_TAG, "action_down");
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    readPb.setBackgroundResource(R.drawable.home_read_selector);
                    Intent intent = new Intent(context,
                            CourseListActivity.class);
                    app.setLearnedType("read");
                    Bundle mBundle = new Bundle();
                    mBundle.putString("type", "1");
                    mBundle.putString("bookid", bookid);
                    mBundle.putString("packageid", packageid);
                    mBundle.putString(LEARN_TYPE, app.getLearnedType());
                    intent.putExtras(mBundle);
                    startActivity(intent);
                    Log.i(FRAGMENT_TAG, "action_up");
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.i(FRAGMENT_TAG, "action_move");
                    return true;
                }
                return false;
            case R.id.hcp_listen:
                return true;
            case R.id.hcp_speak:
                return true;
            case R.id.hcp_words:
                return true;
            case R.id.hcp_test:
                return true;
            default:return false;
        }
    }
}
