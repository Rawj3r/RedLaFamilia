package nkosi.roger.og.za.com.hub.code.redlafamilia.API;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by empirestate on 2/8/16.
 */
public interface RedApi {

    @GET("/feeds/flowers.json")
    public void getFeeds(Callback<String> feeds);
}
