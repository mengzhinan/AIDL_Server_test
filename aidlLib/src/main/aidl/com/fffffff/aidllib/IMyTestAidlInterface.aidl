// IMyTestAidlInterface.aidl
package com.fffffff.aidllib;

// Declare any non-default types here with import statements
import com.fffffff.aidllib.IMyTestCallback;

interface IMyTestAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void searchKeyWord(int anInt, String aString, IMyTestCallback myCallback);

    int addNum(int a, int b);
}
