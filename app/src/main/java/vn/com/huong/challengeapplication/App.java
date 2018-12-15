package vn.com.huong.challengeapplication;

import android.app.Application;

import vn.com.huong.challengeapplication.internal.di.component.AppComponent;
import vn.com.huong.challengeapplication.internal.di.component.DaggerAppComponent;
import vn.com.huong.challengeapplication.internal.di.module.AppModule;
import vn.com.huong.challengedata.di.modules.NetworkModule;

/**
 * Created by HuongPN on 12/14/2018.
 */
public class App extends Application {

    private static App app;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initAppComponent();

        this.app = this;

    }

    /**
     * init dagger component
     */
    private void initAppComponent() {

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASEURL, BuildConfig.CACHETIME, BuildConfig.DEBUG))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getInstance() {
        return app;
    }
}
