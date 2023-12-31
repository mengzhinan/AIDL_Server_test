// IMyTestCallback.aidl
package com.fffffff.aidllib;

// Declare any non-default types here with import statements
import com.fffffff.aidllib.UserData;

interface IMyTestCallback {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onResult(String msg, in UserData userData);

    void onFailure(String error);
}
