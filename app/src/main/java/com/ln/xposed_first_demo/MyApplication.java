package com.ln.xposed_first_demo;

import android.app.Application;
import android.util.Log;

/**
 * Created by SecretBase on 2017/2/5.
 */
public class MyApplication extends Application {
    public static Application self;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("my","myApplication oooooooooooooooooooooooocreate");
        self=this;
    }


}
