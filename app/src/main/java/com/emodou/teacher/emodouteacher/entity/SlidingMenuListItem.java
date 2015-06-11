package com.emodou.teacher.emodouteacher.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by woody on 2015/5/28.
 */
public class SlidingMenuListItem {
    private String title;
    private int icon;

    public SlidingMenuListItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }


    public void setIcon(int icon) {
        this.icon = icon;
    }
}
