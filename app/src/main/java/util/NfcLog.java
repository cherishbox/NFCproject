package util;


import android.util.Log;

/**
 * Created by lydia on 2015/7/18.
 */
public class NfcLog {

    private static final String TAG = "NFC_Project_";

    public static void v(String tag, String message)
    {
        Log.v(TAG + tag, message);
    }
    public static void d(String tag, String message)
    {
        Log.d(TAG + tag, message);
    }
    public static void e(String tag, String message)
    {
        Log.e(TAG + tag, message);
    }
    public static void w(String tag, String message)
    {
        Log.w(TAG + tag, message);
    }
    public static void i(String tag, String message)
    {
        Log.i(TAG + tag, message);
    }


}


