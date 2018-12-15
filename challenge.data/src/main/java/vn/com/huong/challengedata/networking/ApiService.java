package vn.com.huong.challengedata.networking;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HuongPN on 12/15/2018.
 */
public interface ApiService {
    @GET("posts")
    Observable<JsonObject> getPosts(@Query("offset") int offset);
}
