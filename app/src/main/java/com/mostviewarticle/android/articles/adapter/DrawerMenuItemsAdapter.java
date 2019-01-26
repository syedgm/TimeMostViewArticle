package com.mostviewarticle.android.articles.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostviewarticle.android.R;
import com.mostviewarticle.android.data.model.DrawerModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DrawerMenuItemsAdapter  extends ArrayAdapter<DrawerModel> {

    private Context context;
    private ArrayList<DrawerModel> drawerModelArrayList;

    public DrawerMenuItemsAdapter(Context context, ArrayList<DrawerModel> drawerModelArrayList) {
        super(context, R.layout.drawer_custom_list, drawerModelArrayList);
        this.context=context;
        this.drawerModelArrayList=drawerModelArrayList;
    }

    @Override
    public int getCount() {
        return drawerModelArrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        DrawerModel drawerModel = drawerModelArrayList.get(position);
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.drawer_custom_list, null);

        }
        TextView title = (TextView) v.findViewById(R.id.title);
        ImageView icon= (ImageView) v.findViewById(R.id.imageViewIcon);

        title.setText(drawerModel.getTitle());
        Picasso.with(context).load(drawerModel.getIcon()).into(icon);

        return  v;
    }

}
