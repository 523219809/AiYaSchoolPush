package com.example.nanchen.aiyaschoolpush;

import android.app.Application;
import android.content.Context;

import com.example.nanchen.aiyaschoolpush.helper.DemoHelper;
import com.mob.mobapi.MobAPI;

import cn.smssdk.SMSSDK;

/**
 * @author nanchen
 * @fileName AiYaSchoolPush
 * @packageName com.example.nanchen.aiyaschoolpush
 * @date 2016/09/08  15:51
 */
public class App extends Application{

    private static final String MSG_APP_KEY = "16faeb1248a89";// 短信验证的app_key
    private static final String MSG_APP_SECRET = "20d994397ced27b44b48ce80956a6f9d";// 短信验证的app_secret
    private static final String MOB_APP_KEY = "1730bae762bbc";// MobApi的应用app_key

    private static App app;

    public static App getInstance(){
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        // LeakCanary
        // if (LeakCanary.isInAnalyzerProcess(this)) {
            // // This process is dedicated to LeakCanary for heap analysis.
            // // You should not init your app in this process.
            // return;
        // }
        // LeakCanary.install(this);

        // 初始化短信验证SDK
        SMSSDK.initSDK(this, MSG_APP_KEY, MSG_APP_SECRET);

        // 初始化MobApiSDK
        MobAPI.initSDK(getApplicationContext(), MOB_APP_KEY);

        //init demo helper
        DemoHelper.getInstance().init(App.getAppContext());
    }

    /**
     * 获取Application Context
     * */
    public static Context getAppContext() {
        return app != null ? app.getApplicationContext() : null;
    }

    public static String currentUserNick = "";
}
