package nkosi.roger.og.za.com.hub.code.redlafamilia.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.List;

import nkosi.roger.og.za.com.hub.code.redlafamilia.R;

/**
 * Created by Nkosi on 3/16/16.
 */
public class HomeNewsAdapter extends ArrayAdapter<NewsList>{


    public HomeNewsAdapter(Context context, int resource, List<NewsList> news) {
        super(context, resource, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewNewsHolder viewNewsHolder;
        View newsView = null;

        if (newsView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            newsView = layoutInflater.inflate(R.layout.headlines_list_row, parent, false);
            viewNewsHolder = new ViewNewsHolder();
            viewNewsHolder.headline_title = (TextView) newsView.findViewById(R.id.headline_title);
            viewNewsHolder.headline_detail = (TextView) newsView.findViewById(R.id.headline_detail);
            viewNewsHolder.headline_thumb = (ImageView) newsView.findViewById(R.id.headline_img_list);
            newsView.setTag(viewNewsHolder);
        }else {
            viewNewsHolder = (ViewNewsHolder) newsView.getTag();
        }

        NewsList current = getItem(position);
        viewNewsHolder.headline_detail.setText(current.getDetail());
        viewNewsHolder.headline_title.setText(current.getTitle());
        Ion.with(viewNewsHolder.headline_thumb).placeholder(R.drawable.ic_menu_gallery).error(R.drawable.ic_menu_gallery).load(current.getImage());
        return newsView;
    }

    static class ViewNewsHolder{
        TextView headline_title, headline_detail;
        ImageView headline_thumb;
    }
}
