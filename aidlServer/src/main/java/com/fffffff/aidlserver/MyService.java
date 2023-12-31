package com.fffffff.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.fffffff.aidllib.IMyTestAidlInterface;
import com.fffffff.aidllib.IMyTestCallback;
import com.fffffff.aidllib.UserData;

/**
 * @Author: duke
 * @DateTime: 2023-09-27 14:04:49
 * @Description: 功能描述：
 */
public class MyService extends Service {

    private IMyTestAidlInterface.Stub myBinder;
    private Handler myHandler = new Handler(Looper.getMainLooper());

    private void createMyBinder() {
        myBinder = new IMyTestAidlInterface.Stub() {
            @Override
            public void searchKeyWord(int i, String s, IMyTestCallback iMyTestCallback) throws RemoteException {
                if (iMyTestCallback == null) {
                    return;
                }

                String result = String.valueOf(i) + "_" + s + "_服务端收到了，返回拼接结果给你！";

                UserData userData = new UserData();
                userData.percentage = i;
                userData.msg = result;
                iMyTestCallback.onResult("服务端处理完毕", userData);
            }

            @Override
            public int addNum(int a, int b) throws RemoteException {
                return a + b;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createMyBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder.asBinder();
    }


}
