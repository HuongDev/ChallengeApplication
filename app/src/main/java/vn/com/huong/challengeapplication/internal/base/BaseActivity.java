package vn.com.huong.challengeapplication.internal.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import vn.com.huong.challengeapplication.App;
import vn.com.huong.challengeapplication.internal.di.component.AppComponent;

/**
 * Created by HuongPN on 12/15/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private AppComponent mAppComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        plusComponent();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Mange the activity component
     */
    private void plusComponent() {
        mAppComponent = App.getInstance().getAppComponent();
    }

    /**
     * Inject component
     */
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
