package vn.com.huong.challengedata.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HuongPN on 12/15/2018.
 */
public class SharedPrefHelper {
    private SharedPreferences mSharedPref;

    public SharedPrefHelper(Context context) {
        mSharedPref = context.getSharedPreferences("app", Context.MODE_PRIVATE);
    }

    /**
     * get/set token
     */
    public String getToken() {
        return mSharedPref.getString(SharedKeys.ACCESS_TOKEN, "");
    }

    public void saveToken(String token) {
        mSharedPref.edit()
                .putString(SharedKeys.ACCESS_TOKEN, token)
                .apply();
    }
}
