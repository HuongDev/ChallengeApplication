package vn.com.huong.challengeapplication.internal.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HuongPN on 12/14/2018.
 */
@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public Context provideAppContext() {
        return mContext;
    }
}
