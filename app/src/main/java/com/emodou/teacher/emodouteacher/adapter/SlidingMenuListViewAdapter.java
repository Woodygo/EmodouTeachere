package com.emodou.teacher.emodouteacher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.emodou.teacher.emodouteacher.R;
import com.emodou.teacher.emodouteacher.entity.SlidingMenuListItem;

import java.util.List;

/**
 * Created by woody on 2015/5/28.
 */
public class SlidingMenuListViewAdapter extends BaseAdapter {
    private List<SlidingMenuListItem> myList;
    private LayoutInflater mInflater;
    private int resource;

    public SlidingMenuListViewAdapter(Context context, List<SlidingMenuListItem> itemList, int resource ) {
        this.resource = resource;
        this.myList = itemList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mInflater.inflate(resource, null);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        SlidingMenuListItem item = myList.get(position);
        holder.icon.setImageResource(item.getIcon());
        holder.title.setText(item.getTitle());

        return convertView;
    }

    class ViewHolder{
        private TextView title;
        private ImageView icon;
    }
}


