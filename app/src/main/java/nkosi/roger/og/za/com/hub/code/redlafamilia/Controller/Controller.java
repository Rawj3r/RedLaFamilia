package nkosi.roger.og.za.com.hub.code.redlafamilia.Controller;

import android.nfc.Tag;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import nkosi.roger.og.za.com.hub.code.redlafamilia.API.RestManager;
import nkosi.roger.og.za.com.hub.code.redlafamilia.Feeds;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by empirestate on 2/8/16.
 */
public class Controller {

    private FeedsCallBacklistener mFeedsCallBacklistener;
    private RestManager restManager;
    private static final String TAG = Controller.class.getSimpleName();

    public Controller(FeedsCallBacklistener feedsCallBacklistener){
        mFeedsCallBacklistener = feedsCallBacklistener;
        restManager = new RestManager();
    }

    public void startFecthing(){
        restManager.getRedApi().getFeeds(new Callback<String>() {

            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON : : " + s);

                try {
                    JSONArray jsonArray = new JSONArray(s);

                    for (int i =0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        Feeds feeds = new Feeds.Builder()
                                .setComment(jsonObject.getString("category"))
                                .setFirstName(jsonObject.getString("instructions"))
                                .setLastName(jsonObject.getString("name"))
                                .setPhoto(jsonObject.getString("photo"))
                                .setTime(jsonObject.getString("productId"))
                                .build();

                        mFeedsCallBacklistener.onFetchProgress(feeds);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    mFeedsCallBacklistener.failed();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "JSON Error : : " + error.getMessage());
            }
        });
    }

    public interface FeedsCallBacklistener{
        void onFetchStart();

        void onFetchProgress(Feeds feeds);

        void onFetchProgress(List<Feeds> feedsList);

        void onFetchComplete();

        void failed();
    }
}
