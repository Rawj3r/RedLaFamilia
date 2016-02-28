package nkosi.roger.og.za.com.hub.code.redlafamilia.API;

import com.google.gson.GsonBuilder;

import nkosi.roger.og.za.com.hub.code.redlafamilia.Utilities.Constants;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by empirestate on 2/8/16.
 */
public class RestManager {

    private RedApi redApi;

    public RedApi getRedApi() {

        if (redApi == null){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(String.class, new StringDesirilizer());

            redApi = new RestAdapter.Builder().setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gsonBuilder.create()))
                    .build()
                    .create(RedApi.class);
        }
        return redApi;
    }
}
