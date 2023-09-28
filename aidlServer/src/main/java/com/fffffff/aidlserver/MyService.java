package com.fffffff.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * @Author: duke
 * @DateTime: 2023-09-27 14:04:49
 * @Description: 功能描述：
 */
public class MyService extends Service {

    private IMyTestAidlInterfaceSub myBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        myBinder = new IMyTestAidlInterfaceSub();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder.asBinder();
    }
}
