package com.fffffff.aidlserver;

import android.os.RemoteException;

import com.fffffff.aidllib.IMyTestAidlInterface;
import com.fffffff.aidllib.IMyTestCallback;
import com.fffffff.aidllib.UserData;

/**
 * @Author: duke
 * @DateTime: 2023-09-28 14:37:00
 * @Description: 功能描述：
 */
public class IMyTestAidlInterfaceSub extends IMyTestAidlInterface.Stub {

    @Override
    public void searchKeyWord(int i, String s, IMyTestCallback iMyTestCallback) throws RemoteException {

        try {
            // 模拟耗时操作
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (iMyTestCallback == null) {
            return;
        }
        String result = String.valueOf(i) + "_" + s + "_服务端收到了，返回拼接结果给你！";

        UserData userData = new UserData();
        userData.percentage = i;
        userData.msg = result;
        iMyTestCallback.onResult(true, userData);
    }
}
