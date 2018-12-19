package vn.com.huong.challengeapplication.internal.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import vn.com.huong.challengeapplication.App;
import vn.com.huong.challengeapplication.LoginActivity;
import vn.com.huong.challengeapplication.MainActivity;
import vn.com.huong.challengeapplication.internal.di.module.AppModule;
import vn.com.huong.challengeapplication.ui.splash.SplashScreenActivity;
import vn.com.huong.challengedata.di.modules.NetworkModule;

/**
 * Created by HuongPN on 12/14/2018.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent extends AndroidInjector<App>{

    void inject(MainActivity mainActivity);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(LoginActivity loginActivity);
}
