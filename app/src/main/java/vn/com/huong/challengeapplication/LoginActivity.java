package vn.com.huong.challengeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.com.huong.challengeapplication.internal.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tvLogin)
    TextView tvLogin;
    @BindView(R.id.tvSignUp)
    TextView tvSignUp;
    @BindView(R.id.tvForgotPass)
    TextView tvFPass;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPass;
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.btnSend)
    Button btnSend;
    @BindView(R.id.constraintUsername)
    ConstraintLayout constraintUsername;

    @BindString(R.string.login)
    String login;
    @BindString(R.string.signup)
    String signup;
    @BindColor(R.color.white)
    int white;
    @BindColor(R.color.text_opacity_pink)
    int pink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // Set default view
        setupLogin();
    }

    private void setupLogin() {
        tvLogin.setTextColor(white);
        tvSignUp.setTextColor(pink);
        constraintUsername.setVisibility(View.GONE);
        tvFPass.setVisibility(View.VISIBLE);
        btnSend.setText(login);
    }

    private void setupSignUp() {
        tvLogin.setTextColor(pink);
        tvSignUp.setTextColor(white);
        constraintUsername.setVisibility(View.VISIBLE);
        tvFPass.setVisibility(View.GONE);
        btnSend.setText(signup);
    }


    @OnClick(R.id.tvLogin)
    public void pageLogin(){
        setupLogin();
    }

    @OnClick(R.id.tvSignUp)
    public void pageSignUp(){
        setupSignUp();
    }

    @OnClick(R.id.btnSend)
    public void loginAndRegister(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @OnClick(R.id.viewPink)
    public void sss(){
        Log.d("s","sss");
    }

    @OnClick(R.id.viewWhite)
    public void ssss(){
        Log.d("s","sss");
    }

    @OnClick(R.id.tvForgotPass)
    public void sssss(){
        Log.d("s","sss");
    }
}
