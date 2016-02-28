package nkosi.roger.og.za.com.hub.code.redlafamilia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nkosi.roger.og.za.com.hub.code.redlafamilia.Utilities.Constants;

/**
 * Created by Roger Nkosi on 2/8/16.
 */
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.Holder>{

    public static String TAG = FeedsAdapter.class.getSimpleName();
    private List<Feeds> feedsList;

    public FeedsAdapter(List<Feeds> feedsList) {
        this.feedsList = feedsList;
    }

    public void addFeed(Feeds feeds){
        feedsList.add(feeds);
        notifyDataSetChanged();
    }

    @Override
    public FeedsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item_row, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(FeedsAdapter.Holder holder, int position) {
        Feeds feed = feedsList.get(position);
        holder.comment.setText(feed.comment);
        holder.timeAdded.setText(feed.timeAdded);
        holder.fullName.setText(feed.firstName);

        Picasso.with(holder.itemView.getContext()).load(Constants.PHOTO_URL + feed.photo).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView fullName, timeAdded, comment;
        public ImageView avatar;


        public Holder(View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);
            fullName = (TextView)itemView.findViewById(R.id.firstName);
            timeAdded = (TextView)itemView.findViewById(R.id.addedTime);
            comment = (TextView)itemView.findViewById(R.id.comment);
        }
    }
}
