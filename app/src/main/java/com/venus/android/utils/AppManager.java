package com.venus.android.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Iterator;
import java.util.Stack;

public class AppManager {
    private static Stack<Activity> stack = new Stack();
    private static volatile AppManager appManager;

    private AppManager() {
    }

    public static AppManager getAppManager() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    public void addActivity(Activity activity) {
        stack.add(activity);
    }

    public Activity currentActivity() {
        return (Activity) stack.lastElement();
    }

    public void finishActivity() {
        Activity activity = (Activity) stack.lastElement();
        popActivity(activity);
        activity.finish();
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            stack.remove(activity);
        }
    }

    public void finishActivity(Class<?> cls) {
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (activity.getClass().equals(cls)) {
                popActivity(activity);
                activity.finish();
            }
        }
    }

    public static void finishAllActivity() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (stack.get(i) != null) {
                ((Activity) stack.get(i)).finish();
            }
        }
        stack.clear();
    }

    public static void exitApp(Context context) {
        try {
            finishAllActivity();
            ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
