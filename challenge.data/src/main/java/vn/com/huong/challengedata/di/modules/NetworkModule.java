package vn.com.huong.challengedata.di.modules;

import android.util.Log;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.com.huong.challengedata.networking.ApiService;
import vn.com.huong.challengedata.sharedpre.SharedPrefHelper;

/**
 * Created by HuongPN on 12/14/2018.
 */
@Module
public class NetworkModule {
    private String mBaseUrl;
    private int mCacheTime;
    private boolean isDebug;

    public NetworkModule(String baseUrl, int cacheTime, boolean isDebug) {
        if (baseUrl == null) {
            throw new IllegalArgumentException("Base url is null");
        }

        this.mBaseUrl = baseUrl;
        this.mCacheTime = cacheTime;
        this.isDebug = isDebug;
    }

    @Provides
    public CallAdapter.Factory provideCallAdapter() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    public OkHttpClient provideClient(SharedPrefHelper sharedPrefHelper) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(getTokenInterceptor(sharedPrefHelper));

        // Logging for dev version.
        if (isDebug) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(logging);
        }

        return httpClientBuilder.build();
    }

    @Provides
    public ApiService provideService(CallAdapter.Factory calladapter, OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(mBaseUrl)
                .client(client)
                .addCallAdapterFactory(calladapter)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        return retrofit.create(ApiService.class);
    }


    private Interceptor getTokenInterceptor(final SharedPrefHelper sharedPrefHelper) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Build headers
                Headers.Builder builder = new Headers.Builder();
                builder.add("Cache-Control", String.format("max-age=%d", mCacheTime));
                builder.add("Content-Type", "application/json");
                String apiToken = sharedPrefHelper.getToken();
                if (apiToken != null) {
                    builder.add("Authorization", apiToken);
                }

                Log.d("Huong", "token " + apiToken);

                // Customize the request
                Request request = original.newBuilder()
                        .headers(builder.build())
                        .removeHeader("Pragma")
                        .build();

                Log.i("request", request + "");
                okhttp3.Response response = chain.proceed(request);
                Log.i("request", response + "");
                response.cacheResponse();

                // Customize or return the response
                return response;
            }
        };
    }
}
