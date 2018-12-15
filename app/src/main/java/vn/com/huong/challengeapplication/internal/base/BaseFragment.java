package vn.com.huong.challengeapplication.internal.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by HuongPN on 12/15/2018.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity baseActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseActivity = (BaseActivity) getActivity();
    }

    public FragmentManager getSupportFragmentManager() {
        return baseActivity.getSupportFragmentManager();
    }
}
