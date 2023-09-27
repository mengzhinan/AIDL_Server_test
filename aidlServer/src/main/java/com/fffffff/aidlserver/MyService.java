package com.fffffff.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.fffffff.aidllib.IMyTestAidlInterface;
import com.fffffff.aidllib.MyCallback;

/**
 * @Author: duke
 * @DateTime: 2023-09-27 14:04:49
 * @Description: 功能描述：
 */
public class MyService extends Service {

    private final IMyTestAidlInterface.Stub binderImpl = new IMyTestAidlInterface.Stub() {

        @Override
        public void searchKeyWord(int i, String s, MyCallback myCallback) throws RemoteException {
            if (myCallback == null) {
                return;
            }
            String result = String.valueOf(i) + "_" + s + "_服务端收到了，返回拼接结果给你！";
            myCallback.onResult(result);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binderImpl;
    }
}
