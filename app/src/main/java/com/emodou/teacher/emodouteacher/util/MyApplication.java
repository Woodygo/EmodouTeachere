package com.emodou.teacher.emodouteacher.util;

import android.app.Application;

/**
 * Created by woody on 2015/6/11.
 */
public class MyApplication extends Application {
    public String getLearnedType() {
        return learnedType;
    }

    public void setLearnedType(String learnedType) {
        this.learnedType = learnedType;
    }

    private String learnedType;;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
