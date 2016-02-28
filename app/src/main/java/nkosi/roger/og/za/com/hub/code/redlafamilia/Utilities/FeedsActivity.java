package nkosi.roger.og.za.com.hub.code.redlafamilia.Utilities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nkosi.roger.og.za.com.hub.code.redlafamilia.Controller.Controller;
import nkosi.roger.og.za.com.hub.code.redlafamilia.Feeds;
import nkosi.roger.og.za.com.hub.code.redlafamilia.FeedsAdapter;
import nkosi.roger.og.za.com.hub.code.redlafamilia.R;

public class FeedsActivity extends AppCompatActivity implements Controller.FeedsCallBacklistener {


    Controller mController;
    private Toolbar toolbar;
    private RecyclerView feedsView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<nkosi.roger.og.za.com.hub.code.redlafamilia.Feeds> feedsList = new ArrayList<>();
    private FeedsAdapter feedsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mController = new Controller(FeedsActivity.this);

        Log.d("test", "Testing if it works");
        mController.startFecthing();

        connfigView();

    }

    private void connfigView() {

        feedsView = (RecyclerView)this.findViewById(R.id.list);
        swipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipe);

        feedsView.setHasFixedSize(true);
        feedsView.setLayoutManager(new LinearLayoutManager(this));
        feedsView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        feedsAdapter = new FeedsAdapter(feedsList);
        feedsView.setAdapter(feedsAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mController.startFecthing();
            }
        });
    }

    private void addFeeds(){
        for (int i=0; i < 1000; i++){
            Feeds feeds = new Feeds.Builder()
                    .setComment("Where is D Byran")
                    .setFirstName("Roger nkosi")
                    .setPhoto("hatatsas")
                    .build();

            feedsAdapter.addFeed(feeds);
        }
    }





    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(nkosi.roger.og.za.com.hub.code.redlafamilia.Feeds feeds) {
        feedsAdapter.addFeed(feeds);
    }

    @Override
    public void onFetchProgress(List<nkosi.roger.og.za.com.hub.code.redlafamilia.Feeds> feedsList) {

    }

    @Override
    public void onFetchComplete() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void failed() {

    }
}
