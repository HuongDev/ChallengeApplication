package vn.com.huong.challengeapplication.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import vn.com.huong.challengeapplication.LoginActivity;
import vn.com.huong.challengeapplication.R;
import vn.com.huong.challengeapplication.internal.base.BaseActivity;

public class SplashScreenActivity extends BaseActivity {

    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
        setContentView(R.layout.activity_splash_screen);

        btnEnter = (Button) findViewById(R.id.btnEnter);

        btnEnter.setOnClickListener(view -> startActivity());
    }

    private void startActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
