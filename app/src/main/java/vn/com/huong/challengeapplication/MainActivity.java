package vn.com.huong.challengeapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;

import vn.com.huong.challengeapplication.internal.base.BaseActivity;

/**
 * Created by HuongPN on 12/15/2018.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
    }
}
