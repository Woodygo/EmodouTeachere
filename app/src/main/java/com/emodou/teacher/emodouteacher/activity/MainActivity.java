package com.emodou.teacher.emodouteacher.activity;



import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;

import com.emodou.teacher.emodouteacher.R;
import com.emodou.teacher.emodouteacher.adapter.SlidingMenuListViewAdapter;
import com.emodou.teacher.emodouteacher.entity.SlidingMenuListItem;
import com.emodou.teacher.emodouteacher.fragment.AssignmentFragment;
import com.emodou.teacher.emodouteacher.fragment.ClassFragment;
import com.emodou.teacher.emodouteacher.fragment.HomeFragment;
import com.emodou.teacher.emodouteacher.fragment.NoticeFragment;
import com.emodou.teacher.emodouteacher.fragment.SolvePuzzleFragment;
import com.emodou.teacher.emodouteacher.view.DragLayout;
import com.meg7.widget.CircleImageView;
import com.nineoldandroids.view.ViewHelper;
import com.umeng.update.UmengUpdateAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yy
 *         15.5.27
 */
public class MainActivity extends FragmentActivity  {
    private FragmentTabHost mTabHost;
    private Class<?> mFragmentArray[] = {HomeFragment.class, ClassFragment.class
    };
    private int mImageArray[] = {R.drawable.home_indicator_book_selector, R.drawable.home_indicator_class_selector
    };
    private String mTagArray[] = {"新任务", "待提交"};

    //自定义布局主页面的根布局，用来实现侧边栏的拖动
    private DragLayout dl;

    //左侧侧边栏的列表
    private ListView lv;
    private TextView tv_noimg;
    //分别表示左上角侧边栏打开前后的两个头像
    private ImageView iv_bottom;

    private CircleImageView iv_icon;

    private List<SlidingMenuListItem> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UmengUpdateAgent.update(this);
        initData();
        setTabHost();
        initDragLayout();
        initView();

    }

    /**
     * 初始化数据信息
     */
    public void initData() {
        itemList = new ArrayList<SlidingMenuListItem>();
        itemList.add(new SlidingMenuListItem(getString(R.string.userinfo), R.drawable.icon_sm_user_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.mybean), R.drawable.icon_sm_bean_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.mycollection), R.drawable.icon_sm_collection_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.myclass), R.drawable.icon_sm_class_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.personality), R.drawable.icon_sm_personality_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.mylist), R.drawable.icon_sm_list_selector));
        itemList.add(new SlidingMenuListItem(getString(R.string.set), R.drawable.icon_sm_set_selector));

    }


    /**
     * 初始化首页布局
     */
    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);

        dl.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {
                lv.smoothScrollToPosition(new Random().nextInt(30));
            }

            @Override
            public void onClose() {
                shake();
            }

            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iv_icon, 1 - percent);
            }

        });
    }

    /**
     * 初始化首页控件
     */
    private void initView() {
        iv_icon = (CircleImageView) findViewById(R.id.iv_icon);
        iv_bottom = (ImageView) findViewById(R.id.iv_bottom);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new SlidingMenuListViewAdapter(
                this,itemList, R.layout.slidingmenu_item_text
                ));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // Util.t(getApplicationContext(), "click " + position);
            }
        });
        iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dl.open();
            }
        });
    }

    /**
     * 创建底部导航标签
     */
    private void setTabHost() {
        // TODO Auto-generated method stub
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realTabcontent);
        mTabHost.getTabWidget().setShowDividers(TabWidget.SHOW_DIVIDER_NONE);
        for (int i = 0; i < mTagArray.length; i++) {
            mTabHost.addTab(
                    mTabHost.newTabSpec(mTagArray[i]).setIndicator(setView(i)),
                    mFragmentArray[i], null);
        }
    }

    @SuppressLint("InflateParams")
    public View setView(int i) {
        View view = getLayoutInflater().inflate(R.layout.home_indicator, null);
        ImageView image = (ImageView) view.findViewById(R.id.imageView1);
        // TextView text = (TextView) view.findViewById(R.id.textView1);
        image.setImageResource(mImageArray[i]);
        //  text.setText(mTagArray[i]);
        return view;
    }

    private void shake() {
        //iv_icon.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
    }


}
